package com.vkochenkov.equationdisplayerlib

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class FontParams(
    val fontSize: TextUnit = 20.sp,
    val fontStyle: androidx.compose.ui.text.font.FontStyle? = null,
    val fontFamily: FontFamily? = null
)
