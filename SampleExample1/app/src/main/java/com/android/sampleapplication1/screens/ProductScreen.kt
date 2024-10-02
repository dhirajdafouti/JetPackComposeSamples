package com.android.sampleapplication1.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable

fun ProductScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()){

    }
}

@Preview
@Composable
fun ProductScreenPreview(){
    ProductScreen(navController = rememberNavController())
}