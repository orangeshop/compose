package com.example.myapplication.chapterOne


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun checkBox() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

//        Checkbox(checked = false, onCheckedChange = {})
//
//        val checked = false
//        Checkbox(checked = checked, onCheckedChange = {
//            checked = !checked
//        })


//        val checked = remember { mutableStateOf(false) }
//        Checkbox(checked = checked.value, onCheckedChange = {
//            checked.value = !checked.value
//        })

//        var checked by remember { mutableStateOf(false) }
//        Checkbox(checked = checked, onCheckedChange = {
//            checked = !checked
//        })



        // it은 반대의 값을 가져옴
        val (checked, setChecked) = remember { mutableStateOf(false) }
        Checkbox(checked = checked, onCheckedChange = {
            setChecked(it)
        })


        Text("프로그래머입니까?",
            modifier = Modifier.clickable {
                setChecked(!checked)
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun checkBoxDefualt(){
    checkBox()
}