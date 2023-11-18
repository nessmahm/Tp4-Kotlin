package com.example.tp4.busschedule.Entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity
data class Schedule(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "Stop_name") val stopName : String,
    @ColumnInfo(name = "Arrival_time") val arrivalTime : Int
)
