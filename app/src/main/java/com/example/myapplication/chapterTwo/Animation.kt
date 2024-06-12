package com.example.myapplication.chapterTwo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Animation() {

    var TextState by remember { mutableStateOf(true) }
    var ColorState by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(
        targetValue = if (ColorState) Color.Red else Color.Blue
    )

    Scaffold(
        modifier = Modifier.padding(16.dp),
        containerColor = backgroundColor
    ) {PaddingValues ->
        Column(
            modifier = Modifier.padding(PaddingValues),

        ) {
//            Text(text = "Hello world")

            AnimatedVisibility(
                visible = TextState,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text(text = "Hello world")
            }

            /** scaleIn()
             *  expandVertically()
             *  fadeIn()
             */

            Row(
                modifier = Modifier.selectable(
                    selected = TextState,
                    onClick = { TextState = true }
                )
            ) {
                RadioButton(selected = TextState, onClick = { TextState = true })
                Text(text = "Hello world 보아기")
            }

            Row(
                modifier = Modifier.selectable(
                    selected = !TextState,
                    onClick = { TextState = false }
                )
            ) {
                RadioButton(selected = !TextState, onClick = { TextState = false })
                Text(text = "Hello world 감추기")
            }


            Text(text = "back ground color change")
            


            Row(
                modifier = Modifier.selectable(
                    selected = ColorState,
                    onClick = { ColorState = true }
                )
            ){
                RadioButton(selected = ColorState, onClick = { ColorState = true })
                Text(text = "red background")
            }

            Row(
                modifier = Modifier.selectable(
                    selected = !ColorState,
                    onClick = { ColorState = false }
                )
            ){
                RadioButton(selected = !ColorState, onClick = { ColorState = false })
                Text(text = "blue background")
            }




            
        }
    }
}



@Composable
@Preview(showBackground = true)
fun AnimationDefaultPreview() {
    Animation()
}