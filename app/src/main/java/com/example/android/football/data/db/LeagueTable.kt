package com.example.android.football.data.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey

//foreignKeys = [ForeignKey(
//entity = Competition::class,
//parentColumns = arrayOf("id"),
//childColumns = arrayOf("competitionId")
//)]

@Entity(tableName = "league_table")
data class LeagueTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val competitionId: Int,
    val name: String,
    val match_played: Int,
    val games: Int,
    val points: Int
) {
    companion object {
        fun populateData() = listOf(
            LeagueTable(0, 1, "ManU", 35, 76, 90),
            LeagueTable(0, 1, "Chelsea", 35, 76, 90),
            LeagueTable(0, 1, "Liverpool", 36, 40, 87),
            LeagueTable(0, 1, "Man City", 36, 19, 85),
            LeagueTable(0, 1, "Spurs", 35, 20, 65),
            LeagueTable(0, 1, "Arsenal", 36, -19, 40),
            LeagueTable(0, 1, "Everton", 33, -30, 43),
            LeagueTable(0, 2, "Barcelona", 33, -30, 43),
            LeagueTable(0, 2, "Realmadrid", 33, -30, 43)

        )
    }
}