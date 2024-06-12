package com.example.myapplication.chapterTwo

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

@Composable
fun sideEffect(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {
    val scaffoldState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = scaffoldState) },
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {

            LaunchedEffect(key1 = scaffoldState) {
                scaffoldState.showSnackbar("Hello compose")
            }

            DisposableEffect(key1 = lifecycleOwner) {

                val observer = LifecycleEventObserver{ _, event ->
                    when(event){
                        Lifecycle.Event.ON_START ->{
                            Log.d("sideEffect", "ON_START")
                        }
                        Lifecycle.Event.ON_STOP ->{
                            Log.d("sideEffect", "ON_STOP")
                        }
                        else ->{
                            Log.d("sideEffect", "else")
                        }
                    }
                }

                lifecycleOwner.lifecycle.addObserver(observer)

                onDispose {
                    lifecycleOwner.lifecycle.removeObserver(observer)
                }
            }
        }
    }
}