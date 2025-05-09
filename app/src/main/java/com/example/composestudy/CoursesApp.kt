package com.example.composestudy

import android.content.res.Resources
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.model.Affirmation
import com.example.composestudy.model.Topic


@Composable
fun CourseCard(modifier: Modifier = Modifier,topic: Topic){
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(3.dp)) {
        Row(){
            Image(painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
                modifier = Modifier.height(100.dp),
                contentScale = ContentScale.FillHeight)

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(topic.stringResourceId))
                Text(text = stringResource(topic.countNum))

            }
        }

    }
}

@Preview
@Composable
private fun AffirmationCardPreview() {
    CourseCard(topic =Topic(R.string.architecture, 58, R.drawable.architecture))
}