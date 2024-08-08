package com.example.acdc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "lista objawów")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "dodaj objawy")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "edytuj objawy")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "wykonaj dzienniczek")
                    }
                    
                }
            }
        }
    }
}

@Composable
fun MyHomeActivityView(){
    val context: Context = LocalContext.current
    val intentHome: Intent = Intent(context, HomeActivity::class.java)
    val intentSymptomListActivity: Intent = Intent(context, SymptomListActivity::class.java)
    val intentAddSymptomActivity: Intent = Intent(context, AddSymptomActivity::class.java)
    val intent: Intent = Intent(context, HomeActivity::class.java)



    
    Button(onClick = { startActivity()}) {
        Text(text = )
        
    }
        
}
