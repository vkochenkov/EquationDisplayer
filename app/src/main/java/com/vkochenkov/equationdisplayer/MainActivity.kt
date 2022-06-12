package com.vkochenkov.equationdisplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
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
                            line = EquationItem(
                                line = "1",
                                superscript = EquationItem(
                                    line = "4",
                                    superscript = "3"
                                )
                            ),
                            underline = EquationItem(
                                line = "1",
                                superscript = EquationItem(
                                    line = "4",
                                    superscript = "3"
                                )
                            ),
                            fontParams = FontParams(
                                fontSize = 60.sp
                            )
                        ).Show()

                        EquationItem(
                            line = "2",
                            underline = "2",
                            subscript = "1",
                            superscript = EquationItem(
                                line = "2",
                                superscript = "2"
                            )
                        ).Show()

                        EquationItem(
                            line = "3",
                            underline = EquationItem(
                                line = "3",
                                subscript = "1",
                                superscript = "2"
                            ),
                        ).Show()

                        EquationItem(
                            line = EquationItem(
                                line = "4",
                                subscript = "1",
                                superscript = "2"
                            ),
                            underline = "4"
                        ).Show()


                            EquationItem(
                                line = listOf(
                                    "x = ",
                                    EquationItem(
                                        line = EquationItem(
                                            line = "x",
                                            superscript = "2",
                                            subscript = listOf(
                                                EquationItem(
                                                    line = "y",
                                                    subscript = "1",
                                                    superscript = "44444"
                                                ),
                                                ", ",
                                                EquationItem(
                                                    line = "y",
                                                    subscript = "2"
                                                ),
                                            )
                                        ),
                                        underline = EquationItem(
                                            line = "y",
                                            superscript = "2"
                                        )
                                    ),
                                    " this the end",
                                ), fontParams = FontParams(
                                    fontSize = 50.sp
                                )
                            ).Show()

                    }
                }
            }
        }
    }
}





