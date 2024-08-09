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

class AddSymptomActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Log.d("!!!!!!!!","sprawdzenie kiedy mnie wywala ")

            val context: Context = LocalContext.current
            val symptomsList = intent.getSerializableExtra("symptomsList") as SymptomsList?
            Log.d("!!!!!!!!","sprawdzenie kiedy mnie wywala 2 + ${symptomsList.toString()} ")

            if (symptomsList != null) {
                AddSymptom(symptomsList)
            }
            val intent = Intent(context, SymptomListActivity::class.java)
            intent.putExtra("symptomsList", symptomsList)


        }
    }
}



@Composable
fun AddSymptom(symptomsList: SymptomsList){
    var text by remember {mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
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
        Log.d("!!!! 1 Utworzenie Symptomu", "został utworzony symptom: $text")
            //dodaje do pobranej listy symptom
            if (symptomsList.getSymptomList().get(0).value == -1){
                symptomsList.updateSymptom(symptomsList.getSymptomList().get(0),symptom)
            }else
            symptomsList.addSymptom(symptom)
        Log.d("!!!! 2 dodanie ","dodawanie symptomu do list")
            // przekazuje liste do symptomsListActivity
        Log.d("!!!! 3 dodanie ","${symptomsList.getSymptomList().last()}")
            Log.d("!!!! 3  ","${symptomsList.getSymptomList().size}")

        }) {
            Text(text = "Zapisz objaw")
        }





    }
}