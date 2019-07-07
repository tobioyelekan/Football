package com.example.android.football.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CompetitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(competitions: List<Competition>)

    @Query("SELECT * FROM competition_table")
    fun getAllCompetitions(): LiveData<List<Competition>>

}