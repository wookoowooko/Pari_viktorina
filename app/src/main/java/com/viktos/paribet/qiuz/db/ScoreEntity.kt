package com.viktos.paribet.qiuz.db

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey


@Keep
@Entity(tableName = "score_entity")
data class ScoreEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val nickName:String,
    val score:String
)