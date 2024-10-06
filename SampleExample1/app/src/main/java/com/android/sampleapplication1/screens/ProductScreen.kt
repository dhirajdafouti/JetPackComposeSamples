package com.android.sampleapplication1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.sampleapplication1.R

@Composable

fun ProductScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White, shape = RectangleShape)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 80.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable(
                            interactionSource = remember {
                                MutableInteractionSource()
                            }, indication = null
                        ) {
                            navController.navigateUp()
                        })
                Text(
                    text = "Product",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(R.drawable.ic_cart),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 30.dp)


            ) {
                Image(
                    painter = painterResource(id = R.drawable.pexels),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 40.dp, end = 40.dp)
                        .aspectRatio(1f)
                        .clip(shape = CircleShape)
                )

            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp, start = 30.dp, end = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Summer Shirt",
                    modifier = Modifier.weight(1f),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                repeat(5) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_star),
                        modifier = Modifier.size(30.dp),
                        contentDescription = null
                    )
                }
            }
            Text(
                text = "This is a fashion product page with one of the design shown in the screenshot",
                modifier = Modifier
                    .padding(top = 40.dp, start = 30.dp, end = 20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Row(
                modifier = Modifier
                    .padding(top = 40.dp, start = 30.dp, end = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProductSize("S")
                ProductSize("M")
                ProductSize("L")
            }

        }

    }

}

@Composable
fun ProductSize(sizeText: String) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentWidth()
            .size(50.dp)
            .border(width = 1.dp, color = Color.Blue, shape = CircleShape)
            .background(color = Color.White, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = sizeText,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview
@Composable
fun ProductScreenPreview() {
    ProductScreen(navController = rememberNavController())
}