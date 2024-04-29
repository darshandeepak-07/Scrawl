package com.apps.todoapp.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.apps.todoapp.R
import com.apps.todoapp.presentation.navigation.AuthRouteScreen
import com.apps.todoapp.presentation.navigation.DashRouteScreen
import com.apps.todoapp.presentation.navigation.Graphs
import com.apps.todoapp.presentation.navigation.graph.RootGraph

@Composable
fun CustomTopBar(
    navController: NavHostController
) {

    Row(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = Color.Gray,
                    start = Offset(
                        0f, y
                    ),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
            .padding(horizontal = 16.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.story_map_o_svgrepo_com),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(40.dp)
        )
        Row(
            modifier = Modifier.clickable { },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Scrawl",
                modifier = Modifier.padding(start = 8.dp),
                style = TextStyle(
                    color = Color.White,
                    fontStyle = FontStyle(R.font.inter_bold),
                    fontSize = 30.sp
                ),
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            modifier = Modifier.size(24.dp),
            onClick = {

            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                tint = Color.White
            )
        }
        IconButton(
            modifier = Modifier
                .padding(start = 24.dp)
                .size(24.dp),
            onClick = {
                navController.navigate(DashRouteScreen.Profile.route)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                tint = Color.White
            )
        }
    }

}