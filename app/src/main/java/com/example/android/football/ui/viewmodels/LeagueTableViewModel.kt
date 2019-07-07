package com.example.android.football.ui.viewmodels

import android.app.Application
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.android.football.data.db.getDatabase
import com.example.android.football.data.repo.LeagueTableRepo

class LeagueTableViewModel(private val competitionId: Int, private val application: Application) : ViewModel() {

    private val dao = getDatabase(application).leagueTableDao
    private val repo = LeagueTableRepo(dao)

    val tables = repo.leagues

    val empty = Transformations.map(tables) {
        it.isNullOrEmpty()
    }

    private fun getLeagueTable() {
        repo.getAllCompetitions(competitionId)
    }

    init {
        getLeagueTable()
    }

}