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

@Composable
fun ComposeConstraints() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (box1, box2, box3, box4) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    end.linkTo(parent.end, margin = 8.dp)
                    bottom.linkTo(parent.bottom, margin = 4.dp)
                }
        ) {
            Text(text = "box One")
        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Blue)
                .constrainAs(box2){
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        ) {

        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(box3){
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    top.linkTo(parent.top)
//                    bottom.linkTo(parent.bottom)

                    centerTo(parent)
//                    cneterHorizontallyTo(parent)
//                    centerVerticallyTo(parent)
                }
        ) {

        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(box4){
                    start.linkTo(box2.end)
                    top.linkTo(box2.bottom)
                }
        ) {

        }

    }
}

@Composable
@Preview(showBackground = true)
fun ComposeConstraintsDefaultPreview() {
    ComposeConstraints()
}