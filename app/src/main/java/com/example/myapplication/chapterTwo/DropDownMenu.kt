package com.example.myapplication.chapterTwo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun dropDownMenu(){
    var expandDropDownMenu by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { expandDropDownMenu = !expandDropDownMenu }) {
            Text(text = "click")
        }

        Text(text = "counter $counter")
    }

    DropdownMenu(expanded = expandDropDownMenu,
        onDismissRequest = { expandDropDownMenu = false }
    ) {
        DropdownMenuItem(text = { Text(text = "증가") }, onClick = { counter += 1 })
        DropdownMenuItem(text = { Text(text = "감소") }, onClick = { counter -= 1 })
    }
}

@Composable
@Preview(showBackground = true)
fun DropDownMenuDefaultPreview() {
    dropDownMenu()
}