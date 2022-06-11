package com.vkochenkov.equationdisplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.*
import com.vkochenkov.equationdisplayer.ui.theme.EquationDisplayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EquationDisplayerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        EquationItem(
                            line = "y",
                            superscript = EquationItem(
                                line = "x",
                                superscript = "2"
                            ),
                            subscript = listOf(
                                EquationItem(
                                    line = "x",
                                    subscript = "1"
                                ),
                                ", ",
                                EquationItem(
                                    line = "b",
                                    superscript = EquationItem(
                                        line = "x",
                                        superscript = "2"
                                    ),
                                    subscript = listOf(
                                        EquationItem(
                                            line = "x",
                                            subscript = "1"
                                        ),
                                        ", ",
                                        EquationItem(
                                            line = "x",
                                            subscript = "2"
                                        ),
                                        ", and little others"
                                    ),
                                    fontParams = FontParams(
                                        fontSize = 40.sp,
                                        fontStyle = FontStyle.Normal,
                                        fontFamily = FontFamily.SansSerif
                                    )
                                ),
                                ", and bigger others"
                            ),
                            fontParams = FontParams(
                                fontSize = 40.sp,
                                fontStyle = FontStyle.Normal,
                                fontFamily = FontFamily.SansSerif
                            )
                        ).Show()

                    }
                }
            }
        }
    }
}




