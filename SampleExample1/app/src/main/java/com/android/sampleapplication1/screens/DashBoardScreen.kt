package com.android.sampleapplication1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.android.sampleapplication1.Screen


@Composable
fun DashBoardScreen(navController: NavController) {
    val searchState = remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Experience \n The Difference",
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp, bottom = 20.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(48.dp))
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(48.dp)
                        ), verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(value = searchState.value, onValueChange = {
                        searchState.value = it
                    }, modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentHeight()
                        .padding(start = 20.dp, end = 16.dp)
                        .weight(1f), singleLine = true, decorationBox = { innerTextField ->
                        if (searchState.value.isEmpty()) {
                            Text(
                                text = "Search",
                                fontSize = 16.sp,
                                color = Color.Gray,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 20.dp)
                                    .wrapContentHeight()
                            )
                        } else {
                            innerTextField()
                        }
                    })
                    Image(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#509790")),
                                shape = RoundedCornerShape(19.dp)
                            )
                            .padding(8.dp), colorFilter = ColorFilter.tint(Color.White)
                    )

                }

            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp), contentPadding = PaddingValues(bottom = 30.dp)
            ) {
                item {
                    ProductView(
                        image = R.drawable.pexels_keith_pottinger,
                        name = "Summer Shirt",
                        price = 345f,
                        modifier = Modifier.padding(end = 16.dp, top = 30.dp),
                        navController = navController
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.pexels_mfooladi,
                        name = "Winter Shirt",
                        price = 345f,
                        modifier = Modifier.padding(end = 16.dp, top = 30.dp),
                        navController = navController
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.pexels,
                        name = "Autumn Shirt",
                        price = 345f,
                        modifier = Modifier.padding(end = 16.dp, top = 30.dp),
                        navController = navController
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.pexels_jeff_denlea,
                        name = "Cold Shirt",
                        price = 345f,
                        modifier = Modifier.padding(end = 16.dp, top = 30.dp),
                        navController = navController
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.pexels_keith_pottinger,
                        name = "Indian Shirt",
                        price = 345f,
                        modifier = Modifier.padding(end = 16.dp, top = 30.dp),
                        navController = navController
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.pexels_boris_ivas,
                        name = "Nepal Shirt",
                        price = 345f,
                        modifier = Modifier.padding(end = 16.dp, top = 30.dp),
                        navController = navController
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(40.dp)) // Ensure last item is fully visible
                }

            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White, shape = RectangleShape
                ).padding(start = 2.dp, top = 10.dp, bottom = 10.dp, end = 2.dp)
                .align(Alignment.BottomEnd)

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.AddCircle,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                    tint = Color(android.graphics.Color.parseColor("#509790"))
                )
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
            }

        }
    }

}


@Composable
fun ProductView(
    image: Int,
    name: String,
    price: Float,
    modifier: Modifier,
    navController: NavController
) {
    ElevatedCard(
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                navController.navigate(Screen.Product.route)
            }
            .border(
                width = 1.dp,
                color = Color.Red,
                shape = RoundedCornerShape(topStart = 20.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 2.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp
                        )
                    )
            )
            Text(
                text = name,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "₹ $price",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, bottom = 4.dp),
                textAlign = TextAlign.Center
            )
        }


    }

}

@Preview
@Composable
fun DashBoardScreenPreview() {
    DashBoardScreen(navController = rememberNavController())
}