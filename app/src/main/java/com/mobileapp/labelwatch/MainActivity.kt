package com.mobileapp.labelwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mobileapp.labelwatch.ui.navigation.NavGraph
import com.mobileapp.labelwatch.ui.theme.LabelwatchTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LabelwatchTheme {
                NavGraph()
            }
        }
    }
}