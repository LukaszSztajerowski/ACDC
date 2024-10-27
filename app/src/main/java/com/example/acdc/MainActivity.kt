package com.example.acdc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.acdc.ui.theme.AddictionCravingDiaryCalendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AddictionCravingDiaryCalendarTheme {
                val context: Context = LocalContext.current
                val intentHomeActivity: Intent = Intent(context, HomeActivity::class.java)
                context.startActivity(intentHomeActivity)

                Log.d("!! Start", "Start Programu")

            }
        }
    }
}

@Composable
fun BackButton() {
    val context: Context = LocalContext.current
    val intentMainActivity: Intent = Intent(context, MainActivity::class.java)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Button(onClick = {
            context.startActivity(intentMainActivity)
        }) {
            Text(text = "powrót")
        }
    }
}