package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar() {
    val name = "World"
    Column {


//        TopAppBar(
//            title = { Text("TopAppbar") },
//            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Red)
//        )


//        TopAppBar(
//            title = { Text("TopAppbar") },
//            navigationIcon = {
//                             IconButton(onClick = { /*TODO*/ }) {
//                                 Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
//                             }
//            },
//            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Red)
//        )


//        TopAppBar(
//            title = { Text("TopAppbar") },
//            navigationIcon = {
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(imageVector = Icons.Filled.Search, contentDescription = null)
//                }
//            },
//            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Red),
//            actions = {
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
//                }
//
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(imageVector = Icons.Filled.AccountBox, contentDescription = null)
//                }
//            }
//        )

        TopAppBar(title = { Text(text = "title") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Blue),
            navigationIcon = {
                             IconButton(onClick = { /*TODO*/ }) {
                                 Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                             }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = null
                    )
                }
            })
        
        Text(text = "Hello $name")
    }
}

@Preview(showBackground = true)
@Composable
fun topAppBarDefaultPreview() {
}