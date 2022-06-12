package com.vkochenkov.equationdisplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import com.vkochenkov.equationdisplayer.ui.theme.EquationDisplayerTheme
import com.vkochenkov.equationdisplayerlib.EquationItem
import com.vkochenkov.equationdisplayerlib.FontParams

class SampleActivity : ComponentActivity() {
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
                            line = "x"
                        ).Show()

                        EquationItem(
                            line = listOf(
                                "f(x) = ",
                                EquationItem(
                                    line = "ax",
                                    superscript = "2"
                                ),
                                " + bx",
                                " + c"
                            )
                        ).Show()

                        EquationItem(
                            line = listOf(
                                "y = ",
                                EquationItem(
                                    line = EquationItem(
                                        line = listOf(
                                            "(x - ",
                                            EquationItem(
                                                line = "1",
                                                underline = "2"
                                            ),
                                            ")"
                                        )
                                    ),
                                    superscript = EquationItem(
                                        line = "2",
                                        superscript = "3"
                                    )
                                )
                            )
                        ).Show()

                        EquationItem(
                            line = "x",
                            sqrt = 2
                        ).Show()

                        EquationItem(
                            line = EquationItem(
                                line = listOf(
                                    "2 + ",
                                    EquationItem(
                                        line = "4",
                                        superscript = "2"
                                    )
                                ),
                                underline = EquationItem(
                                    line = "3",
                                    underline = "2",
                                    sqrt = 2
                                )
                            ),
                            sqrt = 2
                        ).Show(fontParams = FontParams(50.sp, fontFamily = FontFamily.Cursive))

                    }
                }
            }
        }
    }
}





