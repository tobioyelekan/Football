package com.example.android.football.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LeagueTableDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(tables: List<LeagueTable>)

    @Query("SELECT * FROM league_table where competitionId=:competitionId")
    fun getLeagueTable(competitionId: Int): LiveData<List<LeagueTable>?>

}