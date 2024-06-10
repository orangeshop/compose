package com.example.myapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scaffold() {
    var (getter, setter) = remember { mutableStateOf(false) }

    Scaffold(topBar = {
        // 스텝 1: `topBar`를 `TopAppBar`로 채워 봅시다.
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "뒤로 가기"
                    )
                }
            },
            title = {
                Text(text = "Scaffold App")
            })
    }) {
        Surface(modifier = Modifier.padding(it)) {
            // 스텝 2: 아래에 CheckBoxWithContent를 넣어봅시다.
            checkBox(
                getter = getter,
                setter = setter
            ) {
                Text("컴포즈를 좋아합니다")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldDefaultPreview() {
    scaffold()
}