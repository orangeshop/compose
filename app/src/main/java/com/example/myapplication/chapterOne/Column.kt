package com.example.myapplication.chapterOne

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun column() {
//    Column(modifier = Modifier.size(100.dp).background(Color.Red)) {
//        Text(text = "Hello")
//        Text(text = "World")
//        Text(text = "Compose")
//    }


//    Column(
//        horizontalAlignment = Alignment.End,
//        modifier = Modifier
//        .size(100.dp)
//        .background(Color.Red)) {
//        Text(text = "Hello")
//        Text(text = "World")
//        Text(text = "Compose")
//    }

//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//        modifier = Modifier
//            .size(100.dp)
//            .background(Color.Red)) {
//        Text(text = "Hello")
//        Text(text = "World")
//        Text(text = "Compose")
//    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .size(100.dp)
    ) {
        Text(text = "Hello",
            modifier = Modifier.align(Alignment.End)
        )
        Text(text = "World")
        Text(text = "Compose")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    column()
}