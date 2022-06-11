package com.vkochenkov.equationdisplayer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

class EquationItem(
    private val line: Any,
    private val superscript: Any? = null,
    private val subscript: Any? = null,
    private val fontParams: FontParams = FontParams()
) {
    @Composable
    fun Show(
        fParams: FontParams = fontParams
    ) {
        Row {
            CheckTypeWithList(line, fParams)
            Column {
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
                for (i in item) {
                    CheckBaseType(i, fontParams)
                }
            }
            else -> {
                CheckBaseType(item, fontParams)
            }
        }
    }

}