package com.vkochenkov.equationdisplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.vkochenkov.equationdisplayer.ui.theme.EquationDisplayerTheme

class PreviewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EquationDisplayerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {

                        com.vkochenkov.equationdisplayerlib.EquationItem(
                            line = listOf(
                                "f(x) = ",
                                com.vkochenkov.equationdisplayerlib.EquationItem(
                                    line = "ax",
                                    superscript = "2"
                                ),
                                " + bx",
                                " + c"
                            )
                        ).Show()

                        com.vkochenkov.equationdisplayerlib.EquationItem(
                            line = listOf(
                                "y = ",
                                com.vkochenkov.equationdisplayerlib.EquationItem(
                                    line = com.vkochenkov.equationdisplayerlib.EquationItem(
                                        line = listOf(
                                            "(x - ",
                                            com.vkochenkov.equationdisplayerlib.EquationItem(
                                                line = "1",
                                                underline = "2"
                                            ),
                                            ")"
                                        )
                                    ),
                                    superscript = com.vkochenkov.equationdisplayerlib.EquationItem(
                                        line = "2",
                                        superscript = "3"
                                    )
                                )
                            )
                        ).Show()
                    }
                }
            }
        }
    }
}





