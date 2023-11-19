package com.paribetqiuz.pari.dep.presenter.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.paribetqiuz.pari.dep.R
import com.paribetqiuz.pari.dep.Screen
import com.paribetqiuz.pari.dep.presenter.QuizViewModel

@Composable
fun RecordsScreen(nav: NavHostController, quizVM: QuizViewModel) {

    LaunchedEffect(Unit) {
        quizVM.getAllScores()
    }

    val listOfRecords by quizVM.listOfRecords.collectAsState()

    Image(
        painter = painterResource(id = R.drawable.back),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {

        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(42.dp)
                .align(Alignment.TopEnd)
                .padding(
                    top = 10.dp,
                    end = 10.dp
                )
                .clickable { nav.navigate(Screen.Welcome.route) }
        )

        if (listOfRecords.isEmpty()) {
            Text(
                text = stringResource(R.string.there_wiil_be_records), color = Color.White,
                fontFamily = FontFamily(Font(R.font.sof)),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.Center),
                overflow = TextOverflow.Ellipsis
            )
        } else {

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(R.string.records), color = Color.White,
                    fontFamily = FontFamily(Font(R.font.sof)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(10.dp),
                    overflow = TextOverflow.Ellipsis
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    itemsIndexed(listOfRecords) { _, item ->
                        Row(
                            modifier = Modifier.fillMaxWidth(0.9f),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = item.nickName, color = Color.White,
                                fontFamily = FontFamily(Font(R.font.sof)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(80f),
                                overflow = TextOverflow.Ellipsis
                            )

                            Text(
                                text = item.score, color = Color.White,
                                fontFamily = FontFamily(Font(R.font.sof)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(20f),
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.End
                            )
                        }
                        Divider(color = Color.White)
                    }
                }
            }


        }
    }
}