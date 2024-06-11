package com.example.myapplication.chapterOne

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun cardView() {
    val data = CardData("https://developer.android.com/static/codelabs/jetpack-compose-animation/img/jetpack_compose_logo_with_rocket_856.png?hl=ko",
        "aaaaaa",
        "aaaaa",
        "aaaaa"
    )

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        ){
            AsyncImage(model = data.imageUrl,
                contentDescription = data.imageDescription,
                modifier = Modifier.size(32.dp),
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(Color.Gray)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(text = data.author)
                Text(text = data.description)
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun CardViewPreview() {
    cardView()
}

data class CardData(val imageUrl:String,
                val imageDescription:String,
                val author:String,
                val description:String
)