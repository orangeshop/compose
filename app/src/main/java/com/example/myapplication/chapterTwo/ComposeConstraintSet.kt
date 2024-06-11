package com.example.myapplication.chapterTwo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId

@Composable
fun ComposeConstraintSet() {

    val constraintSet = ConstraintSet {
        val redBox = createRefFor("redBox")
        val blueBox = createRefFor("blueBox")
        val magentaBox = createRefFor("magentaBox")
        val yellowBox = createRefFor("yellowBox")

        constrain(redBox){
            end.linkTo(parent.end, margin = 8.dp)
            bottom.linkTo(parent.bottom, margin = 4.dp)
        }

        constrain(blueBox){
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }

        constrain(magentaBox){
            centerTo(parent)
        }

        constrain(yellowBox){
            start.linkTo(blueBox.end)
            top.linkTo(blueBox.bottom)
        }
    }

    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = Modifier.fillMaxSize()
    ) {
//        val (box1, box2, box3, box4) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
        ) {
            Text(text = "box One")
        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Blue)
                .layoutId("blueBox")
        ) {

        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .layoutId("magentaBox")
        ) {

        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .layoutId("yellowBox")
        ) {

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ComposeConstraintSetDefaultPreview() {
    ComposeConstraintSet()
}