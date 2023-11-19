package com.paribetqiuz.pari.dep.presenter

import android.content.Context
import com.paribetqiuz.pari.dep.R

class GetQuestionsUseCase(private val context: Context) {
    fun execute(): List<QuizModel> {
        return listOf(
            QuizModel(
                question = context.getString(R.string.q1), answers = listOf(
                    context.getString(R.string.a1_1),
                    context.getString(R.string.a1_2),
                    context.getString(R.string.a1_3),
                    context.getString(R.string.a1_4)
                ), correctAnswer = 4
            ), QuizModel(
                question = context.getString(R.string.q2), answers = listOf(
                    context.getString(R.string.a2_1),
                    context.getString(R.string.a2_2),
                    context.getString(R.string.a2_3),
                    context.getString(R.string.a2_4)
                ), correctAnswer = 3
            ), QuizModel(
                question = context.getString(R.string.q3), answers = listOf(
                    context.getString(R.string.a3_1),
                    context.getString(R.string.a3_2),
                    context.getString(R.string.a3_3),
                    context.getString(R.string.a3_4)
                ), correctAnswer = 1
            ), QuizModel(
                question = context.getString(R.string.q4), answers = listOf(
                    context.getString(R.string.a4_1),
                    context.getString(R.string.a4_2),
                    context.getString(R.string.a4_3),
                    context.getString(R.string.a4_4)
                ), correctAnswer = 2
            ), QuizModel(
                question = context.getString(R.string.q5), answers = listOf(
                    context.getString(R.string.a5_1),
                    context.getString(R.string.a5_2),
                    context.getString(R.string.a5_3),
                    context.getString(R.string.a5_4)
                ), correctAnswer = 2
            ), QuizModel(
                question = context.getString(R.string.q6), answers = listOf(
                    context.getString(R.string.a6_1),
                    context.getString(R.string.a6_2),
                    context.getString(R.string.a6_3),
                    context.getString(R.string.a6_4)
                ), correctAnswer = 1
            ), QuizModel(
                question = context.getString(R.string.q7), answers = listOf(
                    context.getString(R.string.a7_1),
                    context.getString(R.string.a7_2),
                    context.getString(R.string.a7_3),
                    context.getString(R.string.a7_4)
                ), correctAnswer = 3
            ), QuizModel(
                question = context.getString(R.string.q8), answers = listOf(
                    context.getString(R.string.q8_1),
                    context.getString(R.string.a8_2),
                    context.getString(R.string.a8_3),
                    context.getString(R.string.a8_4)
                ), correctAnswer = 4
            ), QuizModel(
                question = context.getString(R.string.q9), answers = listOf(
                    context.getString(R.string.a9_1),
                    context.getString(R.string.a9_2),
                    context.getString(R.string.a9_3),
                    context.getString(R.string.a9_4)
                ), correctAnswer = 1
            ), QuizModel(
                question = context.getString(R.string.q10), answers = listOf(
                    context.getString(R.string.a10_1),
                    context.getString(R.string.a10_2),
                    context.getString(R.string.a10_3),
                    context.getString(R.string.a10_4)
                ), correctAnswer = 4
            ), QuizModel(
                question = context.getString(R.string.q11), answers = listOf(
                    context.getString(R.string.a11_1),
                    context.getString(R.string.a11_2),
                    context.getString(R.string.a11_3),
                    context.getString(R.string.a11_4)
                ), correctAnswer = 2
            ), QuizModel(
                question = context.getString(R.string.q12), answers = listOf(
                    context.getString(R.string.q12_1),
                    context.getString(R.string.q12_2),
                    context.getString(R.string.q12_3),
                    context.getString(R.string.q12_4)
                ), correctAnswer = 3
            ), QuizModel(
                question = context.getString(R.string.q13), answers = listOf(
                    context.getString(R.string.q13_1),
                    context.getString(R.string.q13_2),
                    context.getString(R.string.q13_3),
                    context.getString(R.string.q13_4)
                ), correctAnswer = 1
            ), QuizModel(
                question = context.getString(R.string.q14), answers = listOf(
                    context.getString(R.string.q14_1),
                    context.getString(R.string.q14_2),
                    context.getString(R.string.q14_3),
                    context.getString(R.string.q14_4)
                ), correctAnswer = 2
            ), QuizModel(
                question = context.getString(R.string.q15),
                answers = listOf(
                    context.getString(R.string.q15_1),
                    context.getString(R.string.q15_2),
                    context.getString(R.string.q15_3),
                    context.getString(R.string.q15_4)
                ), correctAnswer = 1
            ), QuizModel(
                question = context.getString(R.string.q16), answers = listOf(
                    context.getString(R.string.q16_1),
                    context.getString(R.string.q16_2),
                    context.getString(R.string.q16_3),
                    context.getString(R.string.q16_4)
                ), correctAnswer = 3
            ), QuizModel(
                question = context.getString(R.string.q17), answers = listOf(
                    context.getString(R.string.q17_1),
                    context.getString(R.string.q17_2),
                    context.getString(R.string.q17_3),
                    context.getString(R.string.q17_4)
                ), correctAnswer = 4
            ), QuizModel(
                question = context.getString(R.string.q18), answers = listOf(
                    context.getString(R.string.a18_1),
                    context.getString(R.string.a18_2),
                    context.getString(R.string.a18_3),
                    context.getString(R.string.a18_4)
                ), correctAnswer = 1
            ), QuizModel(
                question = context.getString(R.string.q19), answers = listOf(
                    context.getString(R.string.a19_1),
                    context.getString(R.string.a19_2),
                    context.getString(R.string.a19_3),
                    context.getString(R.string.a19_4)
                ), correctAnswer = 2
            ), QuizModel(
                question = context.getString(R.string.q20), answers = listOf(
                    context.getString(R.string.q20_1),
                    context.getString(R.string.q20_2),
                    context.getString(R.string.q20_3),
                    context.getString(R.string.q20_4)
                ), correctAnswer = 1
            ), QuizModel(
                question = context.getString(R.string.q21), answers = listOf(
                    context.getString(R.string.a21_1),
                    context.getString(R.string.a21_2),
                    context.getString(R.string.a21_3),
                    context.getString(R.string.a21_4)
                ), correctAnswer = 1
            ), QuizModel(
                question = context.getString(R.string.q22), answers = listOf(
                    context.getString(R.string.q22_1),
                    context.getString(R.string.q22_2),
                    context.getString(R.string.q22_3),
                    context.getString(R.string.q22_4)
                ), correctAnswer = 4
            ), QuizModel(
                question = context.getString(R.string.q23), answers = listOf(
                    context.getString(R.string.q23_1),
                    context.getString(R.string.q23_2),
                    context.getString(R.string.q23_3),
                    context.getString(R.string.q23_4)
                ), correctAnswer = 1
            ), QuizModel(
                question = context.getString(R.string.q24),
                answers = listOf(context.getString(R.string.q24_1),
                    context.getString(R.string.q24_2), context.getString(R.string.q24_3),
                    context.getString(R.string.q24_4)),
                correctAnswer = 3
            ), QuizModel(
                question = context.getString(R.string.q25), answers = listOf(
                    context.getString(R.string.q25_1),
                    context.getString(R.string.q25_2),
                    context.getString(R.string.q25_3), context.getString(R.string.q25_4)
                ), correctAnswer = 4
            )
        )
    }
}