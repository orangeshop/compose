package com.example.myapplication


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun row() {
//    Row(modifier = Modifier.height(40.dp)){
//        Text(text = "1")
//        Text(text = "2")
//        Text(text = "3")
//    }

//    Row(modifier = Modifier.height(40.dp)){
//        Text(text = "1", modifier = Modifier.align(Alignment.Top))
//        Text(text = "2", modifier = Modifier.align(Alignment.CenterVertically))
//        Text(text = "3", modifier = Modifier.align(Alignment.Bottom))
//    }

//    Row(modifier = Modifier.height(40.dp),
//        verticalAlignment = Alignment.Bottom
//    ){
//        Text(text = "1", modifier = Modifier.align(Alignment.Top))
//
//        Text(text = "2")
//        Text(text = "3")
//    }

    /**
     *
     */

//    Row(
//        horizontalArrangement = Arrangement.Center,
//        modifier = Modifier.height(40.dp).width(200.dp),
//        verticalAlignment = Alignment.Bottom
//    ){
//        Text(text = "1", modifier = Modifier.align(Alignment.Top))
//
//        Text(text = "2")
//        Text(text = "3")
//    }

    Row(
        modifier = Modifier.height(40.dp).width(200.dp),
        verticalAlignment = Alignment.Bottom
    ){
        Text(text = "1", modifier = Modifier.align(Alignment.Top).weight(3f))
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterVertically).background(Color.Red)
        )

        Text(text = "3", modifier = Modifier.weight(3f))
    }


}

@Preview(showBackground = true)
@Composable
fun rowPreview() {
    MyApplicationTheme {
        row()
    }
}