package com.example.acdc.model

import java.io.Serializable
import java.util.UUID

data class Symptom(
    val name: String,
    val value: Int,
    val id: String = UUID.randomUUID().toString()
) : Serializable
