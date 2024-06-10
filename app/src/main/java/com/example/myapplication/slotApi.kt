package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
fun slotApi() {
    val (getterOne, setterOne) = remember{ mutableStateOf(false) }
    val (getterTwo, setterTwo) = remember{ mutableStateOf(false) }

    Column(
    ){
        checkBox(getter = getterOne, setter = setterOne){
            Text(text = "One", modifier = Modifier.clickable(
                onClick = {
                    setterOne(!getterOne)
                }
            ))
        }

        checkBox(getter = getterTwo, setter = setterTwo){
            Text(text = "Two", modifier = Modifier.clickable(
                onClick = {
                    setterOne(!getterOne)
                }
            ))
        }
    }
}


@Composable
fun checkBox(getter :Boolean, setter : (Boolean) -> Unit,
             content : @Composable RowScope.() -> Unit){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(checked = getter, onCheckedChange = { setter(!getter)})
        content()
    }
}

/**
 * 외부에서 click 이벤트를 주입가능
 */
//@Composable
//fun checkBox(getter :Boolean, setter : (Boolean) -> Unit,
//             content : @Composable RowScope.() -> Unit){
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically
//    ){
//        Checkbox(checked = getter, onCheckedChange = { setter(!getter)})
//        content()
//    }
//}

/**
 * 외부에서 click 이벤트를 사용해야함
 * RowScope.()  전
 */
//@Composable
//fun checkBox(getter :Boolean, setter : (Boolean) -> Unit,
//             content : @Composable () -> Unit){
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically
//    ){
//        Checkbox(checked = getter, onCheckedChange = { setter(!getter)})
//        content()
//    }
//}

//@Composable
//fun checkBox(getter :Boolean, setter : (Boolean) -> Unit, name: String){
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically
//    ){
//        Checkbox(checked = getter, onCheckedChange = { setter(!getter)})
//        Text(
//            text = "check1 $name",
//            modifier = Modifier.clickable {
//                setter(!getter)
//            }
//        )
//    }
//}

@Preview(showBackground = true)
@Composable
fun slotApiPreview(){
    slotApi()
}