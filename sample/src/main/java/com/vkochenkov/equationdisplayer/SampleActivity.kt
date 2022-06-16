package com.vkochenkov.equationdisplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import com.vkochenkov.equationdisplayer.ui.theme.EquationDisplayerTheme
import com.vkochenkov.equationdisplayerlib.EquationItem
import com.vkochenkov.equationdisplayerlib.FontParams
import kotlin.math.sqrt

class SampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EquationDisplayerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        EquationItem(
                            line = listOf(
                                "g + ",
                                EquationItem(
                                    line = "x",
                                    sqrt = 2
                                )
                            ),
                            underline = listOf(
                                "r",
                                EquationItem(
                                    line = "y",
                                    sqrt = 2
                                )
                            )
                        ).Show()

                        EquationItem(
                            line = listOf(
                                "x = ",
                                EquationItem(
                                    line = EquationItem(
                                        line = "x",
                                        superscript = "2",
                                        subscript = "2"
                                    ),
                                    underline = "y",
                                    sqrt = 2
                                )
                            )
                        ).Show()

                        EquationItem(
                            line =

                            EquationItem(
                                line = listOf(
                                    EquationItem(
                                        line = "x",
                                        superscript = "2"
                                    ),
                                    " + ",
                                    EquationItem(
                                        line = "4",
                                        superscript = EquationItem(
                                            line = "1 + 1234",
                                            underline = "2",
                                            sqrt = 2
                                        )
                                    )
                                ),
                                sqrt = 2,
                                underline = "hello"

                            ),
                            underline = EquationItem(
                                line = "some value",
                                sqrt = 2
                            )
                        ).Show()


                        EquationItem(
                            line = listOf(
                                "f(x) =",
                                EquationItem(
                                    line = "ax",
                                    superscript = "2",
                                    sqrt = 2
                                ),
                                " + bx + c"
                            ),
                        ).Show(
                            FontParams(
                                fontSize = 30.sp,
                                fontFamily = FontFamily.Cursive,
                                fontStyle = FontStyle.Normal
                            )
                        )
                    }
                }
            }
        }
    }
}