package com.example.acdc

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.acdc.model.SymptomsList

class MakeDiaryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context: Context = LocalContext.current
            val list = getList(context)[0]
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center)
            {

                MakeDiaryActivity(list)
                BackButton()
            }
        }
    }
}

@Composable
fun MakeDiaryActivity (symptomsList: SymptomsList) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    )
    {
        val list = symptomsList.getSymptomList()
        list.forEachIndexed { index, symptom ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "${index + 1}. ${symptom.name}", modifier = Modifier.weight(1f))
                val values = listOf(0, 1, 2, 3)
                values.forEach { value ->
                    RadioButton(
                        selected = symptom.value == value,
                        onClick = {
                            // stworzyć funkcjonalność


                        }
                    )
                    Text(text = "$value")
                }
            }
        }
    }
}