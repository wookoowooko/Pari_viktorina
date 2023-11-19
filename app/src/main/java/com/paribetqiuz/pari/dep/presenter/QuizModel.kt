package com.paribetqiuz.pari.dep.presenter

data class QuizModel(
    val question:String,
    val answers:List<String>,
    val correctAnswer:Int
)