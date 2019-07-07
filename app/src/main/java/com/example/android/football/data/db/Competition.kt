package com.example.android.football.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "competition_table")
data class Competition(
    @PrimaryKey
    val id: Int,
    val name: String
) {
    companion object {
        fun populateData() = listOf(
            Competition(1, "Premier league 2017/2018"),
            Competition(2, "La-Liga"),
            Competition(3, "Champions League"),
            Competition(4, "League One"),
            Competition(5, "League Two"),
            Competition(6, "Ligue"),
            Competition(7, "DFB-Pokal 2017/2018")
        )
    }
}