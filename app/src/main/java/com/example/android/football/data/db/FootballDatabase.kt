package com.example.android.football.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [Competition::class, LeagueTable::class], version = 1)
abstract class FootballDatabase : RoomDatabase() {
    abstract val competitionDao: CompetitionDao
    abstract val leagueTableDao: LeagueTableDao
}

private lateinit var INSTANCE: FootballDatabase

fun getDatabase(context: Context): FootballDatabase {
    synchronized(FootballDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE =
                Room.databaseBuilder(
                    context.applicationContext,
                    FootballDatabase::class.java,
                    "football_database"
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                            GlobalScope.launch {
                                insertData(context)
                            }
                        }
                    })
                    .build()
        }
    }
    return INSTANCE
}

fun insertData(context: Context) {
    getDatabase(context).competitionDao.insertAll(Competition.populateData())
    getDatabase(context).leagueTableDao.insertAll(LeagueTable.populateData())
}