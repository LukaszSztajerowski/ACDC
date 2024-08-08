package com.example.acdc

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
import com.example.acdc.model.Symptom

class AddSymptomActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            AddSymptom()



        }
    }
}

@Composable
fun AddSymptom(){
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
        Log.d("Utworzenie Symptomu", "został utworzony symptom: $text")
            //pobieram liste z main activity

            //dodaje do pobranej listy symptom

            // przekazuje liste do symptomsListActivity


        }) {
            Text(text = "Zapisz objaw")
        }





    }
}