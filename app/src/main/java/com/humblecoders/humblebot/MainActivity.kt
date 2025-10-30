package com.humblecoders.humblebot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.humblecoders.humblebot.ui.theme.HumbleBotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HumbleBotTheme {
                // Call the UI from here
            }
        }
    }
}

