package com.apps.todoapp.presentation.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import com.apps.todoapp.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent

@Composable
fun ThoughtCard(
    creator : String? = null,
    thought : String? = null
) {
    Card(
        modifier = Modifier.padding(10.dp),
        shape = RectangleShape,
        border = BorderStroke(0.5.dp,MaterialTheme.colorScheme.primary),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){

        Column( modifier = Modifier.padding(bottom = 5.dp)){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.background(MaterialTheme.colorScheme.primary).fillMaxWidth().padding(5.dp)
            )
            {
                IconButton(onClick = {}, modifier = Modifier.size(30.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(
                    text = creator ?: "",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        fontStyle = FontStyle(R.font.inter_extrabold)
                    ),
                    modifier = Modifier.padding(start = 10.dp),
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = thought ?: "",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 13.sp,
                    fontWeight = FontWeight(600),
                    fontStyle = FontStyle(R.font.inter_extrabold)
                ),
                modifier = Modifier.padding(5.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(5.dp)
            ) {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(35.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.thumbs_up),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }

                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(35.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.comment_lines_svgrepo_com),
                        contentDescription = null
                    )
                }

                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(35.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.share_svgrepo_com),
                        contentDescription = null
                    )
                }
            }
        }
    }
}