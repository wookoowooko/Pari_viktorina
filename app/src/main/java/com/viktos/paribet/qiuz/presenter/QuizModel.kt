package com.viktos.paribet.qiuz.presenter

data class QuizModel(
    val question:String,
    val answers:List<String>,
    val correctAnswer:Int
)