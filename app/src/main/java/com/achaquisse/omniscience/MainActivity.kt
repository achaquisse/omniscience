package com.achaquisse.omniscience

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.achaquisse.omniscience.ui.screen.CourseListScreen
import com.achaquisse.omniscience.ui.theme.OmniscienceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OmniscienceTheme {
                CourseListScreen()
            }
        }
    }
}