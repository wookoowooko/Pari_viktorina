package com.paribetqiuz.pari.dep.presenter.ui

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.paribetqiuz.pari.dep.R
import com.paribetqiuz.pari.dep.Screen
import com.paribetqiuz.pari.dep.db.ScoreEntity
import com.paribetqiuz.pari.dep.presenter.QuizViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun FinalScreen(quizVM: QuizViewModel, nav: NavHostController) {
    

    val openAlertDialog = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val correctAnswer by quizVM.rightAnswer.collectAsState()
    var text by rememberSaveable { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var isSaved by remember { mutableStateOf(false) }
    val saved = stringResource(R.string.saved)

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        bottomBar = {},
        topBar = {},
    ) { paddingValues ->
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
            contentAlignment = Alignment.Center
        ) {

            if (openAlertDialog.value) {
                Dialog(onDismissRequest = { openAlertDialog.value = false }) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(16.dp),
                        shape = RoundedCornerShape(16.dp),
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(R.string.input_your_nickname), color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.sof)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 17.sp,
                                modifier = Modifier.padding(10.dp),
                                overflow = TextOverflow.Ellipsis
                            )
                            Divider()
                            TextField(
                                isError = isError,
                                value = text,
                                onValueChange = { text = it },
                                singleLine = true,
                                textStyle = TextStyle(
                                    color = Color.Black,
                                    fontFamily = FontFamily(Font(R.font.sof)),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                )
                            )
                            Divider()
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = stringResource(R.string.save), color = Color.Black,
                                    fontFamily = FontFamily(Font(R.font.sof)),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .clickable {
                                            if (text.isEmpty()) {
                                                isError = true
                                            } else {
                                                quizVM.insertScore(
                                                    data = ScoreEntity(
                                                        nickName = text,
                                                        score = correctAnswer.toString()
                                                    )
                                                )
                                                scope.launch {
                                                    snackbarHostState.showSnackbar(
                                                        saved,
                                                        duration = SnackbarDuration.Short
                                                    )
                                                    nav.navigate(Screen.Welcome.route)
                                                }
                                                isSaved = true
                                                openAlertDialog.value = false


                                            }
                                        },
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = stringResource(R.string.cancel),
                                    color = Color.Black,
                                    fontFamily = FontFamily(Font(R.font.sof)),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .clickable {
                                            openAlertDialog.value = false
                                        },
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.right_answers), color = Color.White,
                    fontFamily = FontFamily(Font(R.font.sof)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(10.dp),
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = correctAnswer.toString(), color = Color.White,
                    fontFamily = FontFamily(Font(R.font.sof)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(10.dp),
                    overflow = TextOverflow.Ellipsis
                )

                if (!isSaved) {
                    Button(
                        modifier = Modifier, enabled = (!openAlertDialog.value), onClick = {
                            openAlertDialog.value = true

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Teal)
                    ) {
                        Text(
                            text = stringResource(id = R.string.save), color = Color.White,
                            fontFamily = FontFamily(Font(R.font.sof)),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(10.dp),
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }


}