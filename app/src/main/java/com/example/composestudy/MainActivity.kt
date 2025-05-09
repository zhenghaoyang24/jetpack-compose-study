package com.example.composestudy

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.core.view.WindowCompat


/*class User constructor(name: String = "your name", age: Int = 0,gender:String) {  // 主要构造函数 constructor 可省略
    var hobby: String = "on hobby"
    var height = 0

    init {  //初始
        println("name:$name,age:$age,gender:$gender")
    }

    constructor(
        name: String = "your name", age: Int = 0,height:Int
    ):this(name,age){
        this.height = height }

    }

    fun printHobby() {
        println("$hobby")
    }
}

fun main() {
    val user = User(age = 18,gender = "boy")
    user.hobby = "basketball"
    user.printHobby()
    val userDefault = User(age = 10,gender = "girl")
    println(user)
    val name: String = "type string"
    val age: Int = 20
    var boy: Boolean = true
    println(name)

    val month: Int = 6
    when (month) {
        in 1..3 -> println("第1季度")
        in 4..6 -> println("第2季度")
        in 7..9 -> println("第3季度")
        in 10..12 -> println("第4季度")
        else -> println("你输的什么？")
    }

    var count = 0
    while (count <= 10) {
        print(count)
        count++
    }

    for (num in 1..10) {
        print("$num")
    }
    for (num in 1 until 10) {
        print("$num ")
    }
    println("")
    for (num in 10 downTo 1 step 2) {
        print("$num ")
    }
    println("")
    for (num in 1 until 20) {
        if (num % 4 == 0) {  // 去掉 4 的倍数
            continue
        }
        print("$num ")
    }
}*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            AffirmationsApp()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GmailApp() {
    val scaffoldState = rememberScaffoldState()
    val rememberCoroutineScope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState,rememberCoroutineScope) },
        drawerContent = {

        }
    ) {


    }
}
