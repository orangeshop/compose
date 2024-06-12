package com.example.myapplication.chapterTwo

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Animation2() {
    var isDarkMode by remember {mutableStateOf(false)}

    val transition = updateTransition(targetState = isDarkMode, label = "다크 모드 애니메이션")

    val background by transition.animateColor(label = "") {
        when(it){
            false -> Color.White
            true -> Color.Black
        }
    }

    val color by transition.animateColor(label = "글자 색") {
        when(it){
            false -> Color.Black
            true -> Color.White
        }
    }


    val alpha by transition.animateFloat(label = "글자 색") {
        when(it){
            false -> 0.7f
            true -> 1f
        }
    }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(background)
                .alpha(alpha),
        ) {
//            Row(
//                modifier = Modifier.selectable(
//                    selected = isDarkMode,
//                    onClick = { isDarkMode = true }
//                ),
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                RadioButton(selected = isDarkMode, onClick = { isDarkMode = true })
//                Text(text = "일반 모드")
//            }

//            Row(
//                modifier = Modifier.selectable(
//                    selected = !isDarkMode,
//                    onClick = { isDarkMode = false }
//                ),
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                RadioButton(selected = !isDarkMode, onClick = { isDarkMode = false })
//                Text(text = "다크 모드")
//            }

            RadioBtnWithText(text = "일반 모드", selected = !isDarkMode, color = color) {
                isDarkMode = false
            }

            RadioBtnWithText(text = "다크 모드", selected = isDarkMode, color = color) {
                isDarkMode = true
            }

//            Row {
//                Box(
//                    modifier = Modifier
//                        .size(40.dp)
//                        .background(Color.Red),
//                ){
//
//                }
//                Box(
//                    modifier = Modifier
//                        .size(40.dp)
//                        .background(Color.Green),
//                ){
//
//                }
//                Box(
//                    modifier = Modifier
//                        .size(40.dp)
//                        .background(Color.Blue),
//                ){
//
//                }
//            }

            Crossfade(targetState = isDarkMode, label = "") { state ->
                when(state) {
                    false -> {
                        Row {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(Color.Red),
                            ) {

                            }
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(Color.Green),
                            ) {

                            }
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(Color.Blue),
                            ) {

                            }
                        }

                    }

                    true -> {
                        Column {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(Color.Red),
                            ) {

                            }
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(Color.Green),
                            ) {

                            }
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(Color.Blue),
                            ) {

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RadioBtnWithText(text:String,
                     color: Color = Color.Black,
                     selected: Boolean,
                     onClick: () -> Unit
){
    Row(
        modifier = Modifier.selectable(
            selected = selected,
            onClick = onClick
        ),
        verticalAlignment = Alignment.CenterVertically
    ){
        RadioButton(selected = selected, onClick = onClick )
        Text(text = text, color = color)
    }
}

@Composable
@Preview(showBackground = true)
fun Animation2Preview() {
    Animation2()
}