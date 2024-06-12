package com.example.myapplication.chapterTwo

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.myapplication.chapterOne.CardData

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ComposeConstraintsCard() {

    val data = CardData("https://developer.android.com/static/codelabs/jetpack-compose-animation/img/jetpack_compose_logo_with_rocket_856.png?hl=ko",
        "aaaaaa",
        "aaaaa",
        "aaaaaasdasdasdasdasd"
    )
    
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (cardImage, author, description) = createRefs()

        AsyncImage(
            model = data.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = ColorPainter(Color.Gray),
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
                .constrainAs(cardImage) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start, margin = 8.dp)
                }
        )

        Text(text = data.author,
            modifier = Modifier.constrainAs(author){
                linkTo(cardImage.end, parent.end, startMargin = 8.dp, endMargin = 8.dp)
                width = Dimension.fillToConstraints
            }
        )

        Text(text = data.description,
            modifier = Modifier.constrainAs(description){
                top.linkTo(author.bottom)
                linkTo(cardImage.end, parent.end, startMargin = 8.dp, endMargin = 8.dp)
                width = Dimension.fillToConstraints
            }
        )
        
    }
    
}

@Composable
@Preview(showBackground = true)
fun ComposeConstraintsCardPreview() {
    ComposeConstraintsCard()
}