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
import com.example.acdc.model.SymptomsList
import com.example.acdc.ui.theme.AddictionCravingDiaryCalendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AddictionCravingDiaryCalendarTheme {
                MyHomeActivityView()
                CreateSymptomList()
                Log.d("Start", "Start Programu")

            }
        }
    }
}

@Composable
fun MyHomeActivityView(){
    val context: Context = LocalContext.current
    val intentSymptomListActivity: Intent = Intent(context, SymptomListActivity::class.java)
    val intentAddSymptomActivity: Intent = Intent(context, AddSymptomActivity::class.java)
    val intentEditSymptomsActivity: Intent = Intent(context, EditSymptomsActivity::class.java)
    val intentMakeDiaryActivity: Intent = Intent(context, MakeDiaryActivity::class.java)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(onClick = { context.startActivity(intentSymptomListActivity) }) {
            Text(text = "lista objawów")
        }
        Button(onClick = { context.startActivity(intentAddSymptomActivity) }) {
            Text(text = "dodaj objawy")
        }
        Button(onClick = { context.startActivity(intentEditSymptomsActivity) }) {
            Text(text = "edytuj objawy")
        }
        Button(onClick = { context.startActivity(intentMakeDiaryActivity) }) {
            Text(text = "wykonaj dzienniczek")
        }

    }
        
}

@Composable
fun CreateSymptomList(){
    val context: Context = LocalContext.current
    val symptomsList = SymptomsList()
    val intent = Intent(context, AddSymptomActivity::class.java)
    intent.putExtra("symptomsList", symptomsList)
    Log.d("!!!! Utworzenie listy objawów", "została utworzona lista symptomów ")
//    context.startActivity(intent)

}