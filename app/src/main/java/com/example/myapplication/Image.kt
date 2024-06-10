package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun image() {
    Column(
        modifier = Modifier.fillMaxSize(),

    ){
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "aaaaa")



        Image(imageVector = Icons.Filled.Settings, contentDescription = "aaaaa")


//        Image(bitmap = , contentDescription = "aaaaa")

    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    image()
}