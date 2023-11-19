package com.paribetqiuz.pari.dep.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paribetqiuz.pari.dep.db.ScoreEntity
import com.paribetqiuz.pari.dep.db.ScoreRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val repo: ScoreRepo,
    getQuestionsUseCase: GetQuestionsUseCase
) : ViewModel() {


    private val _quizList = MutableStateFlow(
        getQuestionsUseCase.execute()
    )
    val quizList = _quizList.asStateFlow()

    private val _rightAnswer = MutableStateFlow(0)
    val rightAnswer = _rightAnswer.asStateFlow()

    fun setRightAnswer() {
        _rightAnswer.value++
    }

    fun insertScore(data: ScoreEntity) {
        viewModelScope.launch {
            repo.insertScore(score = data)
        }
    }

    private val _listOfRecords = MutableStateFlow<List<ScoreEntity>>(emptyList())
    val listOfRecords = _listOfRecords.asStateFlow()

    fun getAllScores() {
        viewModelScope.launch {
            _listOfRecords.value = repo.getAll()
        }
    }

}