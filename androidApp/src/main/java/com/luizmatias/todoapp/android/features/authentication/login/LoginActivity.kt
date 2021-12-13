package com.luizmatias.todoapp.android.features.authentication.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luizmatias.todoapp.android.ui.theme.AppTheme

@ExperimentalMaterial3Api
class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
private fun LoginScreen() {
    AppTheme {
        //TOdo login screen
    }
}


@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen()
}