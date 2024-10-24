package com.example.acdc.util

import android.content.Context
import com.example.acdc.model.SymptomsList

object StorageOperations {

    fun writeSymptomsList(context: Context, symptomsList: List<SymptomsList>){
        val json = JsonConverter.symptomsListListToJson(symptomsList)
        val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE).edit()
        sharedPrefs.putString(SYMPTOM_LIST_KEY, json)
        sharedPrefs.apply()
    }

    fun readSymptomList(context: Context): List<SymptomsList> ?{
        val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME,Context.MODE_PRIVATE)
        val json = sharedPrefs.getString(SYMPTOM_LIST_KEY,null)

        return if(json != null) JsonConverter.symptomsListListFromJson(json) else emptyList()
    }


    private const val SHARED_PREFS_NAME = "SYMPTOM_LIST_SHARED_PREFS"
    private const val SYMPTOM_LIST_KEY = "SYMPTOM_LIST_KEY"


}

