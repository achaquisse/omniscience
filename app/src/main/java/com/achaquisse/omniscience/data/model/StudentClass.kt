package com.achaquisse.omniscience.data.model

import java.util.Date

data class StudentClass(
    val id: Int,
    val levelName: String,
    val startDate: Date,
    val endDate: Date,
    val shiftName: String
)