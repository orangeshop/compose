package com.example.myapplication


import androidx.activity.ComponentActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun surface(name : String){
    /**
     * 해당 함수 위에 감싸는 듯한
     */
//    Surface(
//        border = BorderStroke(width = 2.dp, color = Color.Magenta),
//    ){
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }

//    Surface(
//        border = BorderStroke(width = 2.dp, color = Color.Magenta),
//        modifier = Modifier.padding(5.dp),
//        shadowElevation = 5.dp
//    ){
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }


//    Surface(
//        border = BorderStroke(width = 2.dp, color = Color.Magenta),
//        modifier = Modifier.padding(5.dp),
//        shadowElevation = 5.dp,
//        shape = CircleShape
//    ){
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }


    /** color = MaterialTheme.colorScheme
     *  onError, onBackground, onSurface, onPrimary, onSecondary 등등 컬러
     */
    Surface(
        border = BorderStroke(width = 2.dp, color = Color.Magenta),
        modifier = Modifier.padding(5.dp),
        shadowElevation = 5.dp,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.onError
    ){
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp)
        )
    }

}