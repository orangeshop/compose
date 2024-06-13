package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.chapterOne.box
import com.example.myapplication.chapterThree.CompositionLocal.CompositionLocal
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//
//                    surface(name = "Android")

//                    box("Android")

//                    networkimage()

//                    cardView()

//                        checkBox()

//                    textField()

//                    topAppBar()

//                    scaffold()

//                    Catalog()

//                    CustomDialog()
//                    dropDownMenu()

//                    snackBar()

//                    bottomAppBar()

//                    state()

//                        Animation()

//                    Animation2()
//                    sideEffect()
//                    TodoTop()

//                    TodoTopViewModel()

//                    TodoTopLivedata()
                    CompositionLocal()
                }
            }

//            setContent {
//                MyApplicationTheme {
//                    // A surface container using the 'background' color from the theme
//                    Surface(
//                        modifier = Modifier.fillMaxSize(),
//                        color = Color.Blue
//                    ) {
////                        scaffold()
//
//                    }
//                }
//            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
//        surface(name = "Android")
        box(name = "Android")
    }
}