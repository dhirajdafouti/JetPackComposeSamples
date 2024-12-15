package com.android.sampleapplication1.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonComposable(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize().padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // provide the elevation to the button
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green,
                contentColor = Color.Red
            ),
            onClick = {
                Toast.makeText(context, "Button clicked", Toast.LENGTH_SHORT).show()
            },
            elevation = ButtonDefaults.buttonElevation(15.dp),
            border = BorderStroke(1.dp, Color.Red),
            modifier = modifier
        ) {
            Text(text = "Filled Button")

        }
        FilledTonalButton(
            onClick = { /*TODO*/ },
            modifier = modifier,
            colors = ButtonDefaults.filledTonalButtonColors()
        ) {
            Text(text = "Filled Tonal Button")
        }

        OutlinedButton(
            onClick = { /*TODO*/ }, modifier = modifier, colors = ButtonColors(
                contentColor = Color.Black,
                containerColor = Color.White,
                disabledContentColor = Color.Black,
                disabledContainerColor = Color.Gray,
            ), border = BorderStroke(1.dp, Color.Black)
        ) {
            // generate the icon for the button
            Text(text = "Outlined Button")
        }

        ElevatedButton(onClick = { /*TODO*/ }, modifier = modifier) {
            Icon(
                imageVector = Icons.Outlined.Add,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.CenterVertically),
                contentDescription = "Add",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Elevated Button")
        }

        TextButton(onClick = { /*TODO*/ }, modifier = modifier) {
            Text(text = "Text Button")

        }

    }

}

@Preview
@Composable
private fun ButtonComposablePreview() {
    Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
        ButtonComposable()
    }
}