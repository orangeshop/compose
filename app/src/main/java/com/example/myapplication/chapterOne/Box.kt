package com.example.myapplication.chapterOne

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp

@Composable
fun box(name: String) {
//    Box(modifier = Modifier.size(100.dp)) {
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.align(Alignment.BottomEnd)
//        )
//    }

//    Box(modifier = Modifier.size(100.dp)) {
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.align(Alignment.BottomEnd)
//        )
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.align(Alignment.TopStart)
//        )
//    }

//    Box(modifier = Modifier.size(100.dp)) {
//        Text(
//            text = "Hello 1!",
//            modifier = Modifier.align(Alignment.BottomEnd)
//        )
//
//        Text(
//            text = "Hello 2!",
//            modifier = Modifier.align(Alignment.CenterEnd)
//        )
//
//        Text(
//            text = "Hello 3!",
//            modifier = Modifier.align(Alignment.TopStart)
//        )
//
//    }

//    Box(modifier = Modifier.size(100.dp)) {
//        Box(modifier = Modifier.size(80.dp).background(Color.Yellow).align(Alignment.CenterStart))
//        Box(modifier = Modifier.size(80.dp).background(Color.Red).align(Alignment.BottomEnd))
//    }

    Box() {
        Box(modifier = Modifier.fillMaxSize().background(Color.Yellow).align(Alignment.CenterStart))
        Box(modifier = Modifier.size(80.dp).background(Color.Red).align(Alignment.BottomEnd))
    }


}