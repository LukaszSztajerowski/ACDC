package com.example.acdc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.acdc.model.Symptom
import com.example.acdc.model.SymptomsList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class CreateSymptomListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context: Context = LocalContext.current

                val symptomsList = SymptomsList(MutableList<Symptom>(1,{Symptom("x",-1)}))
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AddSymptom(symptomsList)
                    SaveButton(symptomsList)
                    BackButton()

                }

        }
    }
}


@Composable
fun CreateSymptomView(symptomsList: SymptomsList){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AddSymptom(symptomsList)
        SaveButton(symptomsList)
    }
}

@Composable
fun AddSymptom(symptomsList: SymptomsList){
    var text by remember {mutableStateOf("")}
        OutlinedTextField(
            value = text, 
            onValueChange = {value -> text = value},
            label = { Text(text = "Objaw napięcia") }
        )
        
        Button(onClick = {
            //tworze symptom
            val symptom = Symptom(
                name = text,
                value = 0)
        Log.d("!! 1 Utworzenie Symptomu", "został utworzony symptom: $text")


            //dodaje do pobranej listy symptom
            if (symptomsList.getSymptomList().get(0).value.equals(-1) ){
                if(symptom.name != ""){
                symptomsList.updateSymptom(symptomsList.getSymptomList().get(0),symptom)}
            }else
                if(symptom.name != ""){
                    symptomsList.addSymptom(symptom)
}

            Log.d("!! 2 dodanie ","${symptomsList.getSymptomList().last()}")
            Log.d("!! 2","${symptomsList.getSymptomList().size}")

            // wyczyszczenie wartosci text fielda
            text = ""
        }) {
            Text(text = "Dodaj objaw")
        }

}

@Composable
fun SaveButton(symptomsList: SymptomsList){
    val context: Context = LocalContext.current
    val intentMainActivity: Intent = Intent(context, MainActivity::class.java)


    Button(onClick = {
//        intentMainActivity.putExtra("symptomsList",symptomsList)
//        context.startActivity(intentMainActivity)

        saveList(context, listOf( symptomsList))    }) {
        Text(text = "zapisz Listę objawów")
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

