package com.example.myapplication.chapterTwo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun snackBar() {
    var counter by remember { mutableStateOf(0) }

    val coroutineScope = rememberCoroutineScope()

    val scaffoldState = remember {SnackbarHostState()}
    Scaffold(
        snackbarHost = { SnackbarHost(scaffoldState) }
    ) {
        Column(modifier = Modifier.padding(it)){
            Button(onClick = {
                counter += 1
                coroutineScope.launch {
                    scaffoldState.showSnackbar(
                        message = "카운터는 $counter 입니다.",
                        actionLabel = "닫기",
                        duration = SnackbarDuration.Short
                    )
                }
            }) {
                Text("더하기")
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun snackBarPreview() {
    snackBar()
}