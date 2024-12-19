package com.android.sampleapplication1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.swipeable
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.sampleapplication1.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetsComposable() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            isSheetOpen = true

        }) {
            Text(text = "Show Bottom Sheet")
        }

    }
    if (isSheetOpen) {
        ModalBottomSheet(
            sheetMaxWidth =BottomSheetDefaults.SheetPeekHeight ,
            sheetState = sheetState,
            onDismissRequest = {
                scope.launch {
                    isSheetOpen = false
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "This is a Bottom Sheet",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.pexels_bertellifotografia),
                    contentDescription = "Image"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetsScaffoldComposable() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
           scope.launch {
               scaffoldState.bottomSheetState.expand()
           }

        }) {
            Text(text = "Show Bottom Sheet")
        }

    }
    BottomSheetScaffold(
        sheetMaxWidth = BottomSheetDefaults.SheetMaxWidth,
        scaffoldState = scaffoldState,
        sheetContainerColor= Color.Red,
        sheetShape = RoundedCornerShape(26.dp),
        sheetPeekHeight = 100.dp,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "This is a Bottom Sheet",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.pexels_bertellifotografia),
                    contentDescription = "Image"
                )
            }
        }

    ) {

    }
}


@Preview
@Composable
private fun BottomSheetsComposablePreview() {

}