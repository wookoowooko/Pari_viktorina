package com.viktos.paribet.qiuz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.viktos.paribet.qiuz.presenter.QuizViewModel
import com.viktos.paribet.qiuz.presenter.ui.FinalScreen
import com.viktos.paribet.qiuz.presenter.ui.Quiz
import com.viktos.paribet.qiuz.presenter.ui.RecordsScreen
import com.viktos.paribet.qiuz.presenter.ui.StartScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val quizVM by viewModels<QuizViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val nav = rememberNavController()
            NavHost(navController = nav, startDestination = Screen.Welcome.route) {
                composable(Screen.Quiz.route) {
                    Quiz(quizVM, nav)
                }
                composable(route = Screen.Final.route) {
                    FinalScreen(quizVM, nav)
                }
                composable(route=Screen.Welcome.route){
                    StartScreen(nav)
                }
                composable(route = Screen.Records.route){
                    RecordsScreen(nav,quizVM)
                }
            }
        }
    }
}

sealed class Screen( val route:String){
    object Quiz : Screen(route = "quiz")
    object Final : Screen(route = "final")
    object Welcome : Screen(route = "welcome")
    object Records : Screen(route = "records")
}
