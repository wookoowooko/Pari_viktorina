package com.paribetqiuz.pari.dep

import android.content.Context
import androidx.room.Room
import com.paribetqiuz.pari.dep.db.ScoreDao
import com.paribetqiuz.pari.dep.db.ScoreDb
import com.paribetqiuz.pari.dep.db.ScoreRepo
import com.paribetqiuz.pari.dep.presenter.GetQuestionsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DI {

    @Provides
    @Singleton
    fun provideScoreDB(@ApplicationContext context: Context): ScoreDb {
        return Room.databaseBuilder(
            context,
            ScoreDb::class.java,
            "ScoreDatabase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideScoreDAO(scoreDB: ScoreDb): ScoreDao {
        return scoreDB.scoreDao()
    }

    @Provides
    @Singleton
    fun provideScoreRepo(dao: ScoreDao): ScoreRepo {
        return ScoreRepo(dao)
    }

    @Provides
    fun provideGetQuestionsUseCase(@ApplicationContext context: Context): GetQuestionsUseCase {
        return GetQuestionsUseCase(context)
    }



}