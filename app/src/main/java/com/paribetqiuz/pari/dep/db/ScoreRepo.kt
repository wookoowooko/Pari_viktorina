package com.paribetqiuz.pari.dep.db

import javax.inject.Inject


class ScoreRepo @Inject constructor(private val dao: ScoreDao) {

    suspend fun insertScore(score: ScoreEntity) {
        dao.insertScore(score)
    }

    suspend fun getAll(): List<ScoreEntity> {
        return dao.getAllScores()
    }

}