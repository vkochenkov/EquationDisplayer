package com.vkochenkov.equationdisplayer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class EquationItem(
    private val line: Any,
    private val underline: Any? = null,
    private val superscript: Any? = null,
    private val subscript: Any? = null,
    private val fontParams: FontParams = FontParams()
) {
    @Composable
    fun Show(
        fParams: FontParams = fontParams
    ) {
        var elementSizePx by remember { mutableStateOf(IntSize.Zero) }
        var isSizeChanged by remember { mutableStateOf(false) }
        val context = LocalContext.current
        val density = context.resources.displayMetrics.density

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.onSizeChanged {
                if (!isSizeChanged) {
                    elementSizePx = it
                    isSizeChanged = true
                }
            }
        ) {
            // main content
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CheckTypeWithList(line, fParams)
                if (underline is String || underline is EquationItem) {
                    Divider(
                        modifier = Modifier.width((elementSizePx.width / density).dp),
                        color = Color.Black,
                        thickness = 2.dp
                    )
                    CheckTypeWithList(underline, fParams)
                }
            }
            // indexes
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.height((elementSizePx.height / density).dp)
            ) {
                val fParamsWithHalf = fParams.copy(
                    fontSize = (fParams.fontSize.value / 2).sp
                )
                Row {
                    CheckTypeWithList(superscript, fParamsWithHalf)
                }
                Row {
                    CheckTypeWithList(subscript, fParamsWithHalf)
                }
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

}