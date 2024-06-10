package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun textField() {

    var name by remember { mutableStateOf("Tom") }

    Column(
        modifier = Modifier.padding(16.dp),
    ) {
//        TextField(value = name, onValueChange = {
//            name = it
//        })

//        TextField(value = name,label = {Text("이름")} ,onValueChange = {name = it})

        OutlinedTextField(value = name, label = {Text("이름")},onValueChange = {name = it})

        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Hello $name")
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldDefaultPreview() {
    textField()
}