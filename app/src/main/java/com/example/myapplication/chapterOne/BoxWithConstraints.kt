package com.example.myapplication.chapterOne

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun boxwithconstraints() {
    outer()
}

@Composable
fun outer(){
    Column {
        inner(modifier = Modifier
            .widthIn(100.dp)
            .heightIn(160.dp)
        )

        inner(modifier = Modifier
            .widthIn(100.dp)
            .heightIn(160.dp)
        )
    }
}

@Composable
fun inner(modifier: Modifier = Modifier){
    BoxWithConstraints(modifier) {
        Text(text = "maxW $maxWidth, maxH $maxHeight minW $minWidth minH $minHeight")
        if(maxHeight > 150.dp){
            Text(
                text = "over Hieght",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun preview(){
    boxwithconstraints()
}

