package com.example.acdc.util

import com.example.acdc.model.SymptomsList
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object JsonConverter {
    private val moshi = Moshi.Builder().build()

    fun symptomsListToJson(symptomsList: SymptomsList): String{
        val type = SymptomsList::class.java
        return moshi.adapter<SymptomsList>(type).toJson(symptomsList)
    }

    fun symptomsListFromJson(json: String): SymptomsList? {
        val type = SymptomsList::class.java
        return moshi.adapter<SymptomsList>(type).fromJson(json)
    }

    fun symptomsListListToJson(symptomsListList: List<SymptomsList>): String{
        val type = Types.newParameterizedType(List::class.java, SymptomsList::class.java)
        return moshi.adapter<List<SymptomsList>>(type).toJson(symptomsListList)
    }

    fun symptomsListListFromJson(json: String): List<SymptomsList>?{
        val type = Types.newParameterizedType(List::class.java, SymptomsList::class.java)
        return moshi.adapter<List<SymptomsList>>(type).fromJson(json)
    }
}

