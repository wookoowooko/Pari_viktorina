package com.paribetqiuz.pari.dep.presenter.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.paribetqiuz.pari.dep.R
import com.paribetqiuz.pari.dep.Screen

@Composable
fun StartScreen(nav: NavHostController) {

    Image(
        painter = painterResource(id = R.drawable.back),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.7f),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(60.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .clickable { nav.navigate(Screen.Quiz.route) },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.start),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .clickable { nav.navigate(Screen.Records.route) },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.records),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    contentScale = ContentScale.Fit
                )
            }


        }
    }
}