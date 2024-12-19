package com.android.sampleapplication1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import com.android.sampleapplication1.screens.DetailedDrawerExample
import com.android.sampleapplication1.screens.NavigationDrawerCompose
import com.android.sampleapplication1.ui.theme.SampleApplication1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleApplication1Theme {
                NavigationDrawerCompose()
                DetailedDrawerExample {
                    LazyColumn {
                        items(100) {
                            Text("Item $it")
                        }
                    }
                }
            }

        }
    }
}


