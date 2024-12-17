package com.android.sampleapplication1.screens

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face2
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.sampleapplication1.ui.theme.SampleApplication1Theme

@Composable
fun CardComposable(modifier: Modifier = Modifier) {
    var localContext = LocalContext.current
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Card(
            modifier = modifier
                .size(width = 240.dp, height = 100.dp)
                .padding(16.dp),
            onClick = {
                Toast.makeText(localContext, "Card Clicked", Toast.LENGTH_SHORT).show()
            },
            shape = RoundedCornerShape(topEnd = 30.dp),
            border = BorderStroke(2.dp, Color.Black),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 12.dp
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Favorite Icon",
                    modifier = Modifier
                        .width(10.dp)
                        .height(10.dp)
                )
                Text("Hello World for Card Default", style = MaterialTheme.typography.labelSmall, textAlign = TextAlign.Center)
            }

        }

        OutlinedCard(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            onClick = {
                Toast.makeText(localContext, "Card Clicked", Toast.LENGTH_SHORT).show()
            },
            shape = RoundedCornerShape(topEnd = 30.dp),
            border = BorderStroke(2.dp, Color.Black),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black,
                disabledContentColor = Color.LightGray,
                disabledContainerColor = Color.Green
            ),
        ) {
            Text("Hello World for Card Outlined", style = MaterialTheme.typography.labelSmall)

        }

        ElevatedCard(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(topEnd = 30.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black,
                disabledContentColor = Color.LightGray,
                disabledContainerColor = Color.Green
            ),
        ) {
            Text("Hello World for Card ElevatedCard", style = MaterialTheme.typography.labelSmall)

        }
    }

}

@Preview
@Composable
fun TextFieldComposable() {
    var text by remember {
        mutableStateOf("")
    }
    var context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black, textAlign = TextAlign.Start
            ),
            onValueChange = { text = it },
            label = { Text("Enter the Weight") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Weight Field"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Face2,
                    contentDescription = "User Name Field"
                )
            },
            placeholder = { Text("Enter User Name") },
            prefix = {
                Text("$")
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
                }
            ),
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = Color.LightGray
            )
        )

    }
}


@Preview(showBackground = true)
@Composable
private fun CardComposablePreviewLight() {
    CardComposable(modifier = Modifier)
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CardComposablePreviewDark() {
    CardComposable(modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
private fun TextFieldComposablePreviewLight() {
    SampleApplication1Theme {
        TextFieldComposable()
    }

}
