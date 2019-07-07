package com.example.android.football.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.android.football.data.db.getDatabase
import com.example.android.football.data.repo.CompetitionRepo

class CompetitionViewModel(application: Application) : AndroidViewModel(application) {

    private val competitionDao = getDatabase(application).competitionDao
    private val repo = CompetitionRepo(competitionDao)

    val competitions = repo.getAllCompetitions()

}
