package com.android.sampleapplication1

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NewJobScreen(modifier: Modifier=Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("New Job", fontWeight = FontWeight.Bold, fontSize = 18.sp) },
                backgroundColor = Color(0xFF213257),
                contentColor = Color.White,

                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.White)
                    }
                }

            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    JobCard(icon = Icons.Default.Search, title = "Load Carriers", count = 1)
                    JobCard(icon = Icons.Default.LocationOn, title = "Items", count = 0)
                    JobCard(icon = Icons.Default.LocationOn, title = "Locations", count = 2)
                }
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { /* Navigate to job details or confirmation */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),

                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF213257)),

                    ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        Text("Start Job", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)

                        Spacer(modifier = Modifier.width(8.dp))

                        Icon(Icons.Default.ArrowForward, contentDescription = "Go", tint = Color.White)


                    }
                }
                Spacer(modifier = Modifier.height(24.dp)) // Added Spacer
                Text(
                    "SYNNAOS GmbH",
                    fontSize = 14.sp,

                    modifier = Modifier.padding(bottom = 8.dp), //Adjust padding
                    fontWeight = FontWeight.Normal


                )
            }
        }
    )
}



@Composable
fun JobCard(icon: ImageVector, title: String, count: Int) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(100.dp),  //adjust size for better visual fit
        elevation = 2.dp, //adjusted elevation
        backgroundColor = Color.White,

        shape = MaterialTheme.shapes.medium //shape is already implemented
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {

            Icon(icon, contentDescription = title, tint = Color(0xFF213257),modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.height(4.dp))
            Text(title, color = Color(0xFF213257), fontSize = 12.sp,fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(4.dp))


            Text(text = count.toString(), color = Color(0xFF213257), fontSize = 16.sp,fontWeight = FontWeight.Bold)



        }
    }
}

@Preview
@Composable
fun PreviewTest2(modifier: Modifier = Modifier) {
    NewJobScreen(modifier)

}