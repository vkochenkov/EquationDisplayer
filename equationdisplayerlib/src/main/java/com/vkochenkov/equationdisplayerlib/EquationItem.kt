package com.vkochenkov.equationdisplayerlib

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class EquationItem(
    private val line: Any,
    private val underline: Any? = null,
    private val superscript: Any? = null,
    private val subscript: Any? = null,
    private val sqrt: Int? = null
) {
    @Composable
    fun Show(
        fontParams: FontParams = FontParams()
    ) {
        var elementHigh by remember { mutableStateOf(0f) }
        var elementWidth by remember { mutableStateOf(0f) }

        var elementHighDp by remember { mutableStateOf(0.dp) }
        var elementWidthDp by remember { mutableStateOf(0.dp) }

        var isSizeChanged by remember { mutableStateOf(false) }

        val context = LocalContext.current
        val density = context.resources.displayMetrics.density

        if (sqrt != null) {
            Row(
                modifier = Modifier.size((fontParams.fontSize.value / 18).dp)
            ) { /* do nothing */ }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.onSizeChanged {
                elementHigh = it.height.toFloat()
                elementHighDp = (elementHigh / density).dp
                if (!isSizeChanged) {
                    elementWidth = it.width.toFloat()
                    elementWidthDp = (elementWidth / density).dp
                    isSizeChanged = true
                }
            }
        ) {
            DrawSqrt(elementWidth, elementHigh, fontParams)
            ShowMainContent(line, underline, fontParams, elementWidthDp)
            ShowIndices(superscript, subscript, fontParams, elementHighDp)
        }
    }

    @Composable
    private fun DrawSqrt(
        elementWidth: Float,
        elementHigh: Float,
        fontParams: FontParams,
    ) {
        val strokeWidth = (fontParams.fontSize.value / 16)
        val color = Color.Black

        if (sqrt != null) {
            val addedWidth = elementWidth / 12
            val downObliquePoint = 0 - addedWidth * 2
            Column(
                modifier = Modifier.width(addedWidth.dp)
            ) { /* do nothing */ }
            Canvas(modifier = Modifier) {
                /* horizontal */
                drawLine(
                    start = Offset(x = 0f, y = 0 - elementHigh / 2),
                    end = Offset(x = elementWidth, y = 0 - elementHigh / 2),
                    color = color,
                    strokeWidth = strokeWidth
                )
                /* oblique */

                drawLine(
                    start = Offset(x = downObliquePoint, y = elementHigh / 2),
                    end = Offset(x = 0f, y = 0 - elementHigh / 2),
                    color = color,
                    strokeWidth = strokeWidth
                )
                /* vertical start */
                drawLine(
                    start = Offset(x = downObliquePoint, y = elementHigh / 2),
                    end = Offset(x = downObliquePoint, y = 0 - elementHigh / 4),
                    color = color,
                    strokeWidth = strokeWidth
                )
            }
        }
    }

    @Composable
    private fun ShowMainContent(
        line: Any,
        underline: Any?,
        fontParams: FontParams,
        elementWidthDp: Dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var newFontParams = fontParams.copy()
            if (underline is String || underline is EquationItem) {
                newFontParams = halfSizedFontParams(fontParams)
                CheckTypeWithList(line, newFontParams)
                Divider(
                    modifier = Modifier.width(elementWidthDp),
                    color = Color.Black,
                    thickness = (newFontParams.fontSize.value / 18).dp
                )
                CheckTypeWithList(underline, newFontParams)
            } else {
                CheckTypeWithList(line, newFontParams)
            }
        }
    }

    @Composable
    private fun ShowIndices(
        superscript: Any?,
        subscript: Any?,
        fontParams: FontParams,
        elementHighDp: Dp
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.height(elementHighDp)
        ) {
            val newFontParams = halfSizedFontParams(fontParams)
            Row {
                CheckTypeWithList(superscript, newFontParams)
            }
            Row {
                CheckTypeWithList(subscript, newFontParams)
            }
        }
    }

    @Composable
    private fun CheckTypeWithList(item: Any?, fontParams: FontParams) {
        when (item) {
            is List<*> -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in item) {
                        CheckBaseType(i, fontParams)
                    }
                }
            }
            else -> {
                CheckBaseType(item, fontParams)
            }
        }
    }

    @Composable
    private fun CheckBaseType(item: Any?, fontParams: FontParams) {
        when (item) {
            is String -> {
                Text(
                    text = item,
                    fontSize = fontParams.fontSize,
                    fontStyle = fontParams.fontStyle,
                    fontFamily = fontParams.fontFamily
                )
            }
            is EquationItem -> {
                item.Show(fontParams)
            }
            else -> {
                Text(text = "", fontSize = fontParams.fontSize)
            }
        }
    }

    private fun halfSizedFontParams(fontParams: FontParams): FontParams {
        return fontParams.copy(
            fontSize = (fontParams.fontSize.value / 2).sp
        )
    }
}