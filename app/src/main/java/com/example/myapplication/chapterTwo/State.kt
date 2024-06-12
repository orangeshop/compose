package com.example.myapplication.chapterTwo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun state() {

    var pyeong by rememberSaveable { mutableStateOf("23") }
    var squaremeter by rememberSaveable {
        mutableStateOf((23 * 3.306).toString())
    }

//    Scaffold(
//        modifier = Modifier.padding(16.dp),
//    ) {PaddingValues ->
//        Column(
//            modifier = Modifier.padding(PaddingValues)
//        ) {
//            OutlinedTextField(
//                value = pyeong,
//                onValueChange = {
//                    if(it.isEmpty()){
//                        pyeong = ""
//                        squaremeter = ""
//                        return@OutlinedTextField
//                    }
//                    val numericvalue = it.toFloatOrNull() ?: return@OutlinedTextField
//                    pyeong = it
//                    squaremeter = (numericvalue * 3.306).toString()
//
//                },
//                label = {
//                    Text(text = "평")
//                }
//            )
//
//            OutlinedTextField(
//                value = squaremeter,
//                onValueChange = {},
//                label = {
//                    Text(text = "제곱미터")
//                }
//            )
//        }
//    }

    stateLess(pyeong, squaremeter){
        if(it.isEmpty()){
            pyeong = ""
            squaremeter = ""
            return@stateLess
        }
        val numericvalue = it.toFloatOrNull() ?: return@stateLess
        pyeong = it
        squaremeter = (numericvalue * 3.306).toString()
    }

}

@Composable
fun stateLess(pyeong: String, squaremeter: String, onPyeongChange: (String) -> Unit){

    Scaffold(
        modifier = Modifier.padding(16.dp),
    ) {PaddingValues ->
        Column(
            modifier = Modifier.padding(PaddingValues)
        ) {
            OutlinedTextField(
                value = pyeong,
                onValueChange = onPyeongChange,
                label = {
                    Text(text = "평")
                }
            )

            OutlinedTextField(
                value = squaremeter,
                onValueChange = {},
                label = {
                    Text(text = "제곱미터")
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun statePreview(){
    state()
}