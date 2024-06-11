package com.example.myapplication.chapterOne

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Catalog() {
    val dataOne = arrayListOf<CatalogData>(
        CatalogData(
        ImgUrl = "https://developer.android.com/static/codelabs/jetpack-compose-animation/img/jetpack_compose_logo_with_rocket_856.png?hl=ko",
        header = "One",
        description = "image One image One image One"
    ), CatalogData(
        ImgUrl = "https://developer.android.com/static/codelabs/jetpack-compose-animation/img/jetpack_compose_logo_with_rocket_856.png?hl=ko",
        header = "One",
        description = "image One image One image One"
    ), CatalogData(
        ImgUrl = "https://developer.android.com/static/codelabs/jetpack-compose-animation/img/jetpack_compose_logo_with_rocket_856.png?hl=ko",
        header = "One",
        description = "image One image One image One"
    ), CatalogData(
        ImgUrl = "https://developer.android.com/static/codelabs/jetpack-compose-animation/img/jetpack_compose_logo_with_rocket_856.png?hl=ko",
        header = "One",
        description = "image One image One image One"
    ), CatalogData(
        ImgUrl = "https://developer.android.com/static/codelabs/jetpack-compose-animation/img/jetpack_compose_logo_with_rocket_856.png?hl=ko",
        header = "One",
        description = "image One image One image One"
    )
    )

    Scaffold(modifier = Modifier.padding(20.dp)) {
        Surface(
            modifier = Modifier.padding(it),
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                item{
                    card(data = dataOne[0]){

                    }
                }
                items(dataOne){item ->
                    card(data = item) {

                    }
                }

            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun card(data: CatalogData, content :@Composable () -> Unit){
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier.height(IntrinsicSize.Max).padding(10.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(model = data.ImgUrl, contentDescription = null, modifier = Modifier.size(200.dp))
            Text(text = data.header)
            Text(text = data.description)
        }
    }
}

data class CatalogData(val ImgUrl : String, val header:String,val description : String)

@Preview(showBackground = true)
@Composable
fun CatalogPreview(){
    Catalog()
}