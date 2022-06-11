package com.vkochenkov.equationdisplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                                ",",
                                EquationItem(
                                    line = "x",
                                    subscript = "2"
                                ),
                                ",and others"
                            ),
                            mFontSize = 40.sp
                        ).Show()

                    }
                }
            }
        }
    }
}

class EquationItem(
    val line: Any,
    val superscript: Any? = null,
    val subscript: Any? = null,
    val mFontSize: TextUnit = 20.sp
) {
    @Composable
    fun Show(
        fontSize: TextUnit = mFontSize
    ) {
        Row {
            CheckTypeWithList(line, fontSize)
            Column {
                val halfFontSize = (fontSize.value / 2).sp
                Row {
                    CheckTypeWithList(superscript, halfFontSize)
                }
                Row {
                    CheckTypeWithList(subscript, halfFontSize)
                }
            }
        }
    }

    @Composable
    private fun CheckBaseType(item: Any?, fontSize: TextUnit) {
        when (item) {
            is String -> {
                Text(
                    text = item,
                    fontSize = fontSize
                )
            }
            is EquationItem -> {
                item.Show(fontSize = fontSize)
            }
            else -> {
                Text(text = "", fontSize = fontSize)
            }
        }
    }

    @Composable
    private fun CheckTypeWithList(item: Any?, fontSize: TextUnit) {
        when (item) {
            is List<*> -> {
                for (i in item) {
                    CheckBaseType(i, fontSize)
                }
            }
            else -> {
                CheckBaseType(item, fontSize)
            }
        }
    }

}




