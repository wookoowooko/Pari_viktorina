package com.paribetqiuz.pari.dep.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ScoreEntity::class], version = 1, exportSchema = false)
abstract class ScoreDb : RoomDatabase() {
    abstract fun scoreDao(): ScoreDao
}