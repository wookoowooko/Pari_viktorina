package com.viktos.paribet.qiuz.presenter.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import com.viktos.paribet.qiuz.R
import com.viktos.paribet.qiuz.Screen
import com.viktos.paribet.qiuz.presenter.QuizViewModel


@Composable
fun Quiz(quizVM: QuizViewModel, nav: NavHostController) {

    val quizList by quizVM.quizList.collectAsState()
    var questionState by remember { mutableIntStateOf(1) }
    val (selectedOption, onOptionSelected) = remember { mutableStateOf<String?>(null) }
    val (enabled, setEnabled) = remember { mutableStateOf(false) }

    fun checkAnswer(): Boolean {
        val currentQuestion = quizList[questionState - 1]
        val isCorrect =
            currentQuestion.answers.indexOf(selectedOption) == currentQuestion.correctAnswer - 1
        if (isCorrect) {
            quizVM.setRightAnswer()
        }
        return isCorrect
    }


    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {

        val (boxWithAnswer, btnNext, question,
            questionBox, background, menuIcon) = createRefs()
        val startGuideline = createGuidelineFromStart(0.1f)
        val endGuideline = createGuidelineFromEnd(0.1f)
        val topGuideLine = createGuidelineFromTop(0.1f)
        val topGuideLine2 = createGuidelineFromTop(0.35f)
        val bottomGuideLine = createGuidelineFromBottom(0.1f)



        Image(painter = painterResource(id = R.drawable.back),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.constrainAs(
                background
            ) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })

        Box(
            modifier = Modifier
                .constrainAs(questionBox) {
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)
                    top.linkTo(topGuideLine)
                    bottom.linkTo(topGuideLine2)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = quizList[questionState - 1].question,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.sof)),
                fontSize = 18.sp,
                modifier = Modifier.padding(10.dp),
                overflow = TextOverflow.Ellipsis
            )
        }
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .constrainAs(menuIcon) {
                    top.linkTo(parent.top, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                }
                .size(32.dp)
                .clickable { nav.navigate(Screen.Welcome.route) }
        )

        Box(
            modifier = Modifier
                .constrainAs(boxWithAnswer) {
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)
                    top.linkTo(topGuideLine2)
                    bottom.linkTo(bottomGuideLine)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectableGroup(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                quizList[questionState - 1].answers.forEach { text ->
                    OutlinedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = {
                                    onOptionSelected(text)
                                    setEnabled(true)
                                },
                                role = Role.RadioButton
                            )
                            .padding(vertical = 10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent,
                        ), border = BorderStroke(1.dp, Color.Green)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Text(
                                text = text,
                                fontFamily = FontFamily(Font(R.font.sof)),
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .weight(90f)
                                    .padding(start = 16.dp)
                                    .padding(10.dp),
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Start
                            )
                            RadioButton(
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.Red,
                                    unselectedColor = Color.Green
                                ),
                                selected = (text == selectedOption), onClick = null,
                                modifier = Modifier
                                    .weight(10f)
                                    .padding(end = 16.dp)
                                    .padding(10.dp)
                            )
                        }
                    }
                }
            }
        }

        Text(
            text = "$questionState/${quizList.size}",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            fontFamily = FontFamily(Font(R.font.sof)),
            modifier = Modifier.constrainAs(
                question
            ) {
                top.linkTo(parent.top)
                start.linkTo(parent.start, 16.dp)
                bottom.linkTo(topGuideLine)

            },
            overflow = TextOverflow.Ellipsis,
        )
        Button(enabled = enabled, onClick = {
            checkAnswer()
            if (quizList.size > questionState) {
                questionState++
            } else {
                nav.navigate(Screen.Final.route)
            }

            onOptionSelected(null)
            setEnabled(false)
        },
            modifier = Modifier.constrainAs(btnNext) {
                start.linkTo(startGuideline)
                end.linkTo(endGuideline)
                bottom.linkTo(parent.bottom, 16.dp)
            }) {
            Text(
                fontFamily = FontFamily(Font(R.font.sof)),
                text = if (quizList.size > questionState) stringResource(R.string.next) else stringResource(
                    R.string.finish
                )
            )
        }

    }
}