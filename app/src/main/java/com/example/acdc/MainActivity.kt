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
import com.example.acdc.model.SymptomsList
import com.example.acdc.ui.theme.AddictionCravingDiaryCalendarTheme
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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


fun saveList(context: Context, list: List<SymptomsList>) {
    val sharedPreferences = context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()

    // Konwersja listy na JSON
    val gson = Gson()
    val json = gson.toJson(list)

    editor.putString("SymptomsList", json)
    editor.apply()
}

fun getList(context: Context): List<SymptomsList> {
    val sharedPreferences = context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
    val gson = Gson()
    val json = sharedPreferences.getString("SymptomsList", null)

    // Typ listy, aby Gson wiedział co konwertować
    val type = object : TypeToken<List<SymptomsList>>() {}.type

    return if (json != null) {
        gson.fromJson(json, type)
    } else {
        emptyList() // Zwraca pustą listę, jeśli nie ma zapisanych danych
    }
}
