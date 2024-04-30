package com.apps.todoapp.presentation.screens.comments.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.apps.todoapp.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommentCard(
    commenter : String,
    comment : String
) {
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = commenter,
            style = TextStyle(
                fontWeight = FontWeight(1000),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.inter_extrabold))
            )
        )
        Text(
            text = comment,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium))
            )
        )
    }
}