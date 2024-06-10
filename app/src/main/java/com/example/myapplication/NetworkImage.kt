package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter


/**
 *""
 */
@Composable
fun networkimage() {

    val image = "https://developer.android.com/static/codelabs/jetpack-compose-animation/img/jetpack_compose_logo_with_rocket_856.png?hl=ko"
    // network 이미지는 preview에서 안보임
    // rememberImagePainter는 duplicate 됨
    // coil에서는 AsyncImage 사용 권고
    Column {
        val painter = rememberImagePainter(data = image)
        Image(painter = painter, contentDescription = null)

        AsyncImage(model = image, contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun networkImagePreview() {
    networkimage()
}