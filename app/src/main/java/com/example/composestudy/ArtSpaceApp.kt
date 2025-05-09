package com.example.composestudy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ArtSpaceLayout() {
    var imageDrawerResult by remember { mutableIntStateOf(1) }
    val imageResource = when (imageDrawerResult) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    val preIsEnabled: Boolean = imageDrawerResult != 1
    val nextIsEnabled : Boolean = imageDrawerResult != 6
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .statusBarsPadding()
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 10.dp,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 4.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = imageResource.toString()
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .background(color = colorResource(R.color.light_purple))
                .padding(vertical = 30.dp)
                .fillMaxWidth()
        ) {
            Text(text = "画名")
            Text(text = "作者")
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 30.dp)
                .fillMaxWidth()
        ) {
            Button(
                enabled = preIsEnabled,
                onClick = {
                    if (imageDrawerResult > 1) {
                        imageDrawerResult = imageDrawerResult - 1
                    }
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.btn_bg_color),
                    contentColor = Color.Black
                )
            ) {
                Text(text = "previous")
            }
            Spacer(modifier = Modifier.weight(1f)) // 占据剩余空间
            Button(
                enabled = nextIsEnabled,
                onClick = {
                    if (imageDrawerResult < 6) {
                        imageDrawerResult = imageDrawerResult + 1
                    }
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.btn_bg_color),
                    contentColor = Color.Black,
                )
            ) {
                Text(text = "Next")
            }
        }
    }

}