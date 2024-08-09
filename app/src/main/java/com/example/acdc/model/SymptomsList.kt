package com.example.acdc.model

import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class SymptomsList(
    val symptoms: MutableList<Symptom> = mutableListOf()
) : Serializable
{

    fun addSymptom(symptom: Symptom) {
        symptoms.add(symptom)
    }

    fun removeSymptom(symptom: Symptom) {
        symptoms.remove(symptom)
    }

    fun updateSymptom(oldSymptom: Symptom, newSymptom: Symptom) {
        val index = symptoms.indexOf(oldSymptom)
        if (index != -1) {
            symptoms[index] = newSymptom
        }
    }

    fun getSymptomList(): List<Symptom> {
        return symptoms
    }
}