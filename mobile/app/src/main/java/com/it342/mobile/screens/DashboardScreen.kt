package com.it342.mobile.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.it342.mobile.utils.SessionManager
import kotlinx.coroutines.launch

@Composable
fun DashboardScreen(sessionManager: SessionManager, onLogout: () -> Unit) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome to your TaskTrack Dashboard!")
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            scope.launch {
                sessionManager.clearSession()
                onLogout()
            }
        }) {
            Text("Logout")
        }
    }
}