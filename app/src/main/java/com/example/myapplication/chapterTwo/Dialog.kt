package com.example.myapplication.chapterTwo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun dialog() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = true }) {
            Text("Click me")
        }
        Text(text = "counter: $counter")
    }

    if (openDialog) {
        AlertDialog(onDismissRequest = {
            openDialog = false
        }, confirmButton = {
            Button(onClick = {
                counter += 1
                openDialog = false }){
                Text("더하기")
            }
        }, dismissButton = {
            Button(onClick = {openDialog = false}) {
                Text(text = "취소")
            }
        }, title = {
            Text(text = "더하기")
        }, text = {
            Text(text = "더하기 버튼을 누르면 어쩌고 저쩌고")
        }
    )}
}

@Composable
@Preview(showBackground = true)
fun DialogDefaultPreview() {
    dialog()
}