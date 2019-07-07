package com.example.android.football.data.repo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.football.data.db.Competition
import com.example.android.football.data.db.CompetitionDao

class CompetitionRepo(private val competitionDao: CompetitionDao) {

    fun getAllCompetitions() = competitionDao.getAllCompetitions()
}