package com.example.composestudy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeAppBar(scaffoldState: ScaffoldState,scope: CoroutineScope){
    Box(modifier = Modifier.padding(10.dp)){
        Card(shape = RoundedCornerShape(10.dp), elevation = 6.dp,
            modifier = Modifier.requiredHeight(60.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(3.dp)
                    .fillMaxSize()
                    .padding(horizontal = 10.dp)) {
                IconButton(onClick = {
                    scope.launch{
                        scaffoldState.drawerState.open()
                    }
                }) { Icon(Icons.Default.Menu,"Menu")}

                Text(text = "This is app bar", modifier = Modifier.weight(0.1f))
                Image(painter = painterResource(id = R.drawable.avatar), contentDescription = "avatar",
                    modifier = Modifier.size(30.dp).clip(CircleShape))
            }
        }
    }
}
