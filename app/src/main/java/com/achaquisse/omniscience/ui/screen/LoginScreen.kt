package com.achaquisse.omniscience.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.achaquisse.omniscience.ui.component.SignInButton
import com.example.omniscience.R

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Image( // Display Google logo at the top
            painter = painterResource(id = R.drawable.ic_omniscience_logo), // Replace with Google logo resource
            contentDescription = "Google Logo",
            modifier = Modifier.size(width = 300.dp, height = 70.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Committed to quality education, open and accessible for everyone.")
        Spacer(modifier = Modifier.height(32.dp))

        SignInButton(
            text = "Sign in with Google",
            loadingText = "Signing in...",
            isLoading = false,
            icon = painterResource(id = R.drawable.ic_google_logo),
            onClick = { }
        )
    }
}


@Preview(device = Devices.PIXEL, showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}