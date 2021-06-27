package com.example.loginappcomp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.loginappcomp.pagescomposable.LoginPage
import com.example.loginappcomp.ui.theme.LoginAppCompTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginAppCompTheme {
                LoginApplication()
            }
        }
    }
}

@Composable
fun LoginApplication(){
    LoginPage()
}

