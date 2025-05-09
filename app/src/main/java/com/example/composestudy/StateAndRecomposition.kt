package com.example.composestudy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

@Composable
fun StateAndRecomposition(){
    var nameState by remember {
        mutableStateOf("")
    }
    var name by rememberSaveable {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = "Hello $name")
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = nameState, onValueChange = {
                nameState = it
            },
            maxLines = 1,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                name = nameState
            }
        ) {
            Text(text = "change")
        }

    }

}