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
                                    superscript = "2"
                                )
                            )
                        ).Show()


                    }
                }
            }
        }
    }
}





