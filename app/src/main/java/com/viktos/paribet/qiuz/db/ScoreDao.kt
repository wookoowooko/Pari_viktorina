package com.viktos.paribet.qiuz.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ScoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScore(score: ScoreEntity)

    @Query("SELECT * FROM score_entity")
    suspend fun getAllScores(): List<ScoreEntity>

}