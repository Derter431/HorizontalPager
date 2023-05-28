package com.example.horizontalpager.core.presentation.components

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
import com.example.horizontalpager.ui.theme.HorizontalPagerTheme
import com.example.horizontalpager.ui.theme.MainScreen
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.HiltAndroidApp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController: SystemUiController = rememberSystemUiController()

            systemUiController.isStatusBarVisible = false // Status bar
            systemUiController.isNavigationBarVisible = false // Navigation bar
            systemUiController.isSystemBarsVisible = false // Status & Navigation bars



            MainScreen()

            }
        }
    }


