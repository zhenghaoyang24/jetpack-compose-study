package com.example.composestudy

import android.R.attr.shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePageConstraintLayout() {

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            // padding 与 border 先声明的修饰符在内层
            .padding(vertical = 100.dp, horizontal =  16.dp)
    ) {
        BoxWithConstraints() {
            val constraints = if (maxWidth < 600.dp) {
                portraitConstraints(16.dp)
            } else {
                landscapeConstraints(16.dp)
            }
            ConstraintLayout(constraints, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "头像",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                        .layoutId("avatar_img")
                )
                Column(modifier = Modifier.layoutId("introduce_colum")) {
                    Text(text = "Hoey")
                    Text(text = "A pserdon.")
                }
            }
        }
    }

}

private fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val avatar_img = createRefFor("avatar_img")
        val introduce_colum = createRefFor("introduce_colum")
        constrain(avatar_img) {
            // 水平居中
            centerHorizontallyTo(parent)
            top.linkTo(parent.top, margin = margin)
        }
        constrain(introduce_colum) {
            top.linkTo(avatar_img.bottom)
            centerHorizontallyTo(parent)
        }
    }
}
private fun landscapeConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val avatar_img = createRefFor("avatar_img")
        val introduce_colum = createRefFor("introduce_colum")
        constrain(avatar_img) {
            // 水平居中
            start.linkTo(parent.start)
//            top.linkTo(parent.top, margin = margin)
        }
        constrain(introduce_colum) {
            start.linkTo(avatar_img.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }
    }
}
