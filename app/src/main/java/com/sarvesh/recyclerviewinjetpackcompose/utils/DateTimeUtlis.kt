package com.sarvesh.recyclerviewinjetpackcompose.utils

object DateTimeUtils {
    fun convertMinutesToHoursAndMinutes(minutes: Int): String {
        val hours = minutes / 60
        val remainingMinutes = minutes % 60
        return "${hours}h ${remainingMinutes}m"
    }
}