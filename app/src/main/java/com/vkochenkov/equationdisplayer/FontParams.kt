package com.vkochenkov.equationdisplayer

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class FontParams(
    val fontSize: TextUnit = 20.sp,
    val fontStyle: FontStyle? = null,
    val fontFamily: FontFamily? = null
)
