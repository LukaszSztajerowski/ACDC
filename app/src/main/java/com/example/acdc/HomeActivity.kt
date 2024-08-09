package com.example.acdc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
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

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyHomeActivityView()
            Log.d("!! home activity", "home activity")

        }
    }
}
@Composable
fun MyHomeActivityView(){
    val context: Context = LocalContext.current
    val intentSymptomListActivity: Intent = Intent(context, SymptomListActivity::class.java)
    val intentCreateSymptomListActivity: Intent = Intent(context, CreateSymptomListActivity::class.java)
    val intentEditSymptomsActivity: Intent = Intent(context, EditSymptomsActivity::class.java)
    val intentMakeDiaryActivity: Intent = Intent(context, MakeDiaryActivity::class.java)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(onClick = {
            context.startActivity(intentCreateSymptomListActivity)
            Log.d("!!!!" ,"stworz dzienniczek głodu")
        }) {
            Text(text = "stworz dzienniczek głodu")

        }

        Button(onClick = {
            context.startActivity(intentSymptomListActivity)
            Log.d("!!!!" ," lista objawow")
        }) {
            Text(text = "lista objawów")
        }

        Button(onClick = {
            context.startActivity(intentEditSymptomsActivity)
            Log.d("!!!!" ," edycja")
        }) {
            Text(text = "edytuj objawy")

        }

        Button(onClick = {
            context.startActivity(intentMakeDiaryActivity)
            Log.d("!!!!" ," wykoanaj")
        }) {
            Text(text = "wykonaj dzienniczek")

        }

    }

}

@Composable
fun BackButton() {
    val context: Context = LocalContext.current
    val intent = Intent(context, MainActivity::class.java)
    context.startActivity(intent)
}