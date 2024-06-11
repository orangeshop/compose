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
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ComposeConstraintsLayout() {
    ConstraintLayout(Modifier.fillMaxSize()){
        val (box1, box2, box3, box4, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    top.linkTo(parent.top, margin = 18.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Blue)
                .constrainAs(box2) {
                    top.linkTo(parent.top, margin = 32.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(box3) {

                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(box4) {
                    top.linkTo(parent.top, margin = 18.dp)
                }
        )

//        createVerticalChain(box1, box2, box3, box4)
//        createHorizontalChain(box1, box2, box3, box4)


        createHorizontalChain(box1, box2, box3, box4, chainStyle = ChainStyle.Spread)
//        createHorizontalChain(box1, box2, box3, box4, chainStyle = ChainStyle.Packed)
//        createHorizontalChain(box1, box2, box3, box4, chainStyle = ChainStyle.SpreadInside)

        var barrier = createBottomBarrier(box1, box2, box3, box4)
//        var barrier = createTopBarrier(box1, box2, box3, box4)
//        var barrier = createStartBarrier(box1, box2, box3, box4)
//        var barrier = createEndBarrier(box1, box2, box3, box4)

        Text(text = "Hello",
            modifier = Modifier.constrainAs(text){
                top.linkTo(barrier)
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ComposeConstraintsLayoutPreview() {
    ComposeConstraintsLayout()
}