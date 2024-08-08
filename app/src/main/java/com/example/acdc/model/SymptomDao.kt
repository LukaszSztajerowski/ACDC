package com.example.acdc.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface SymptomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSymptom(symptom: Symptom)

    @Update
    suspend fun updateSymptom(symptom: Symptom)

    @Delete
    suspend fun deleteSymptom(symptom: Symptom)
}