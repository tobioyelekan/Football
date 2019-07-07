package com.example.android.football.data.repo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.android.football.data.db.LeagueTableDao

class LeagueTableRepo(private val leagueDao: LeagueTableDao) {

    private val competitionId = MutableLiveData<Int>()

    val leagues = Transformations.switchMap(competitionId) {
        leagueDao.getLeagueTable(it)
    }

    fun getAllCompetitions(id: Int) {
        competitionId.value = id
    }
}