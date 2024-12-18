package com.android.sampleapplication1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.sampleapplication1.screens.AppBarDefaultComposable
import com.android.sampleapplication1.ui.theme.SampleApplication1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleApplication1Theme {
                AppBarDefaultComposable()
            }
        }
    }
}


