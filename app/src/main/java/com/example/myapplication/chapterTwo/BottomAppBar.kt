package com.example.myapplication.chapterTwo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun bottomAppBar() {
    val scaffoldState = remember { SnackbarHostState() }
    val coroutine = rememberCoroutineScope()
    var count by remember { mutableStateOf(0) }
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = scaffoldState)},
        bottomBar = {
            BottomAppBar(){
                Text(text = "Hello")
                Button(onClick = {
                    coroutine.launch {
                        scaffoldState.showSnackbar("hello2")
                    }
                }) {
                    Text(text = "인사하기")
                }

                Button(onClick = {
                    count += 1
                }) {
                    Text(text = "+")
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Box(
            ) {
                Text(
                    text = "counter : $count",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun bottomAppBarDefaultPreview() {
    bottomAppBar()
}