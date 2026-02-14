package com.it342.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.it342.mobile.screens.LoginScreen
import com.it342.mobile.screens.DashboardScreen
import com.it342.mobile.utils.SessionManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sessionManager = SessionManager(this)

        setContent {
            var currentScreen by remember { mutableStateOf("login") }
            val token by sessionManager.authToken.collectAsState(initial = null)

            // Auto-navigate to dashboard if token exists
            LaunchedEffect(token) {
                if (token != null) currentScreen = "dashboard"
            }

            when (currentScreen) {
                "login" -> LoginScreen(sessionManager) { currentScreen = "dashboard" }
                "dashboard" -> DashboardScreen(sessionManager) { currentScreen = "login" }
            }
        }
    }
}