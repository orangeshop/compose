package com.example.myapplication.chapterThree.CompositionLocal

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CompositionLocal() {
    
    Card(
        modifier = Modifier.padding(16.dp)
    ) {
//        CompositionLocalProvider(value = LocalContentAlpha provides ContentAlpha.disabled) {
//            Text(text = "안녕하세요 ㅁㅁㅁㅁㅁㅁ")
//            CompositionLocalProvider(value = LocalContentAlpha provides ContentAlpha.disabled) {
//                Text(text = "안녕하세요 ㅁㅁㅁㅁㅁㅁ")
//                Text(text = "안녕하세요 ㅁㅁㅁㅁㅁㅁ")
//            }
//            Text(text = "안녕하세요 ㅁㅁㅁㅁㅁㅁ")
//            Text(text = "안녕하세요 ㅁㅁㅁㅁㅁㅁ")
//            Text(text = "안녕하세요 ㅁㅁㅁㅁㅁㅁ")
//            Text(text = "안녕하세요 ㅁㅁㅁㅁㅁㅁ")
//        }
    }
}

@Composable
@Preview(showBackground = true)
fun CompositionLocalPreview() {
    CompositionLocal()
}