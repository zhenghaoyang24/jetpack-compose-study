package com.example.composestudy

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.constraintlayout.compose.ConstraintLayout
import kotlin.coroutines.coroutineContext

/*
布局基础
 */

@Composable
fun ProfilePage() {
    Card(
        elevation  = 6.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp, bottom = 100.dp, start = 20.dp, end = 20.dp)
    ) {
        Column(modifier =  Modifier.verticalScroll(rememberScrollState()).padding(20.dp), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "头像",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, color = Color.Black, shape = CircleShape)
            )
            Text(text = "Hoey")
            Text(text = "A pserdon.")
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ProfileStats("100", "Followers")
                ProfileStats("30", "Following")
                ProfileStats("5", "Posts")
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {}) {
                    Text(text = "Follow Me")
                }
                Button(onClick = {}) {
                    Text(text = "Direct Message")
                }
            }
            ConstraintLayout() {
                val guideLine = createGuidelineFromTop(0.5f)
                val (test1,test2) = createRefs()
                Text(text = "文本1", modifier = Modifier.constrainAs(test1){
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    top.linkTo(guideLine)
                })
                Text(text = "文本2", modifier = Modifier.constrainAs(test2) {
                    top.linkTo(test1.bottom)
                })
            }
        }
    }
}

@Composable
fun ProfileStats(count: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}

@Preview
@Composable
fun ProfilePageVIew() {
    ProfilePage()
}