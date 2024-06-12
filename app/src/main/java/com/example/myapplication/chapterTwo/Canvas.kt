package com.example.myapplication.chapterTwo

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun canvas() {
    Canvas(
        modifier = Modifier.size(100.dp),
        onDraw = {
            drawLine(Color.Red, Offset(0f, 0f), Offset(50f, 50f))

            drawCircle(Color.Blue, 30f, Offset(10f, 10f))

            drawRect(Color.Green, Offset(40f, 40f), Size(50f, 50f))


        }
    )
}

@Preview(showBackground = true)
@Composable
fun CanvasDefaultPreview() {
    canvas()
}