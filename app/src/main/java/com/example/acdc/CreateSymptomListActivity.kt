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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import com.example.acdc.model.Symptom
import com.example.acdc.model.SymptomsList
import java.util.Date


class CreateSymptomListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context: Context = LocalContext.current

                val symptomsList = SymptomsList(MutableList<Symptom>(1,{Symptom("x",-1)}), Date())
                Log.d("dodanie czasu","${symptomsList.date}")
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(text = "Aby stworzyć dzienniczek napięcia zastanów sie przez chwile i zapisz po 5 objawów z każdej kategorii tak, żeby ich łączna suma wynosiła 20 pozycji:")
                    Text(text = "MYŚLI, UCZUCIA, ZACHOWANIA, REAKCJE ORGANIZMU")
                    AddSymptom(symptomsList)
                    SaveButton(symptomsList)
                    BackButton()

                }

        }
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
            if (symptomsList.getSymptomList()[0].value == -1){
                if(symptom.name != ""){
                symptomsList.updateSymptom(symptomsList.getSymptomList().get(0),symptom)}
            }else
                if(symptom.name != ""){
                    symptomsList.addSymptom(symptom)
}
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
        saveList(context, listOf( symptomsList))    }) {
        Text(text = "zapisz Listę objawów")
    }
}

