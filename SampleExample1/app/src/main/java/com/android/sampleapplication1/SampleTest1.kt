package com.android.sampleapplication1



import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.CircleShape


// Sample Data - Replace with your actual data model.  Consider using a ViewModel for real app.
data class Shoe(val image: Int, val price: String, val name: String, val rating: Float)
data class Brand(val image: Int, val name: String)

@Composable
fun ShoeAppScreen() {
    val shoes = remember {
        listOf(
            Shoe(R.drawable.pexels_bertellifotografia, "$250", "Sport Shoes", 4.6f), //replace with your images.
            Shoe(R.drawable.ic_launcher_foreground, "$285", "Sport Shoes", 4.2f),
            Shoe(R.drawable.ic_launcher_foreground, "$180", "Casual Shoes", 4.1f),
            Shoe(R.drawable.ic_launcher_foreground, "$220", "Sport Shoes", 4.8f)
        )
    }
    val brands = remember {
        listOf(
            Brand(R.drawable.ic_launcher_foreground, "Adidas"), //replace with your images
            Brand(R.drawable.ic_launcher_foreground, "Nike"),
            Brand(R.drawable.ic_launcher_foreground, "Puma"),
            Brand(R.drawable.ic_launcher_foreground, "Skechers"),
            Brand(R.drawable.ic_launcher_foreground, "Reebok")
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Shoe App", color = Color.White) })
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            NewCollectionSection()
            Spacer(modifier = Modifier.height(16.dp))
            OfficialBrandsSection(brands = brands)
            Spacer(modifier = Modifier.height(16.dp))
            RecommendationsSection(shoes = shoes)
        }
    }
}


@Composable
fun BottomNavigationBar(){
    BottomNavigation(backgroundColor = Color(0xFF6200EE)) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Explore", tint = Color.White) },
            label = { Text("Explorer", color = Color.White) },
            selected = false,
            onClick = { }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Cart", tint = Color.White) },
            label = { Text("Cart", color = Color.White) },
            selected = false,
            onClick = { }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Wishlist", tint = Color.White) },
            label = { Text("Wishlist", color = Color.White) },
            selected = false,
            onClick = { }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "My Order", tint = Color.White) },
            label = { Text("My Order", color = Color.White) },
            selected = false,
            onClick = { }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Profile", tint = Color.White) },
            label = { Text("Profile", color = Color.White) },
            selected = false,
            onClick = { }
        )
    }
}


@Composable
fun NewCollectionSection() {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("New Collection", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text("Discount 50% for first transaction", fontSize = 14.sp)
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(start = 8.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EE))) {
                Text("Shop Now", color = Color.White)
            }

        }
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), //replace with your images.
            contentDescription = "New Shoe",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )
    }
}


// ... (OfficialBrandsSection and RecommendationsSection remain largely the same, but with improved styling)

@Composable
fun OfficialBrandsSection(brands: List<Brand>) {
    Column {
        Text("Official Brand", style = MaterialTheme.typography.h6) // Use Material typography
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            brands.forEach { brand ->
                BrandItem(brand)
            }
        }

        Text("See all", style = MaterialTheme.typography.caption, modifier = Modifier.align(Alignment.End))
    }

}

@Composable
fun BrandItem(brand: Brand) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { /* Handle click */ }) {
        Image(
            painter = painterResource(id = brand.image), //replace with your images
            contentDescription = brand.name,
            modifier = Modifier.size(40.dp).clip(CircleShape),
            contentScale = ContentScale.Fit
        )
        Text(brand.name, fontSize = 12.sp, textAlign = TextAlign.Center)
    }
}

@Composable
fun RecommendationsSection(shoes: List<Shoe>) {
    Column {
        Text("Recommendation", style = MaterialTheme.typography.h6)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(shoes) { shoe ->
                ShoeItem(shoe)
            }
        }
        Text("See all", style = MaterialTheme.typography.caption, modifier = Modifier.align(Alignment.End))
    }
}

@Composable
fun ShoeItem(shoe: Shoe) {
    Card(
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
                }
                Image(
                    painter = painterResource(id = shoe.image), //replace with your images
                    contentDescription = shoe.name,
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Fit
                )
            }
            Text(shoe.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text("$${shoe.price}", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text("Rating: ${shoe.rating}", fontSize = 12.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShoeAppScreenPreview() {
    ShoeAppScreen()
}