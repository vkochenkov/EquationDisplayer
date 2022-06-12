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
            var newFontParams = fontParams

            // square root
            if (sqrt != null && sqrt == 2) {
                Column(
                    modifier = Modifier.width((newFontParams.fontSize.value/18).dp)
                ) {

                }
                Canvas(modifier = Modifier) {
                    val canvasWidth = elementWidth
                    val canvasHeight = elementHigh

                    //todo improve draw
                    drawLine(
                        start = Offset(x = 0f, y = 0 - elementHigh / 2),
                        end = Offset(x = elementWidth, y = 0 - elementHigh / 2),
                        color = Color.Black,
                        strokeWidth = (newFontParams.fontSize.value/5)
                    )

                    drawLine(
                        start = Offset(x = 0f, y = elementHigh / 2),
                        end = Offset(x = 0f, y = 0 - elementHigh / 2),
                        color = Color.Black,
                        strokeWidth = (newFontParams.fontSize.value/5)
                    )
                }
            }
            // main content
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (underline is String || underline is EquationItem) {
                    newFontParams = newFontParams.copy(
                        fontSize = (newFontParams.fontSize.value / 2).sp
                    )
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
            // indices
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.height(elementHighDp)
            ) {
                newFontParams = newFontParams.copy(
                    fontSize = (newFontParams.fontSize.value / 2).sp
                )
                Row {
                    CheckTypeWithList(superscript, newFontParams)
                }
                Row {
                    CheckTypeWithList(subscript, newFontParams)
                }
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
}