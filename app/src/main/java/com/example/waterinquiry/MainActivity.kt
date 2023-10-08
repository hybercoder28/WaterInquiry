package com.example.waterinquiry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.waterinquiry.navigation.AppNavigation
import com.example.waterinquiry.ui.theme.WaterInquiryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterInquiryTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}
