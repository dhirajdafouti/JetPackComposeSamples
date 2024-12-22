package com.android.sampleapplication1.screens

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.sampleapplication1.R


@Composable
fun DialogCompose() {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        androidx.compose.material3.AlertDialog(
            shape = RoundedCornerShape(16.dp),
            containerColor = Color(0xFFD0BCFF),
            titleContentColor = Color.White,
            textContentColor = Color.Black,
            icon = {
                Icon(painter = painterResource(R.drawable.ic_star
                ), contentDescription = null, tint = Color.White)
            },
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                androidx.compose.material.Text("Dialog Title")
            },
            text = {
                androidx.compose.material.Text("This is a dialog message")
            },
            confirmButton = {
                androidx.compose.material.TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    androidx.compose.material.Text("Ok")
                }
            },
            dismissButton = {
                androidx.compose.material.TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    androidx.compose.material.Text("Cancel")
                }
            }
        )
    }


}

@Preview(showBackground = true)
@Composable
private fun DialogComposePreview() {
    Surface(contentColor = Color.White) { DialogCompose() }

}