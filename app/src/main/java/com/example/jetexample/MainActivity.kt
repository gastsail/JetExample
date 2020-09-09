package com.example.jetexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.example.jetexample.bottomnav.BottomNavWithLabels


/**
 * How to run the samples:
 * Just call the Composable methods of the packages inside setContent
 * Example: setContent { Toolbar() } ---> this will trigger the Toolbar() composable
 * inside the toolbar package where this UI code resides
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Call here what you want to try out
            BottomNavWithLabels()
        }
    }
}







