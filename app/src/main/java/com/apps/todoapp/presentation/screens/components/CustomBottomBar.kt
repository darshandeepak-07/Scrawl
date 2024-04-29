package com.apps.todoapp.presentation.screens.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.apps.todoapp.presentation.navigation.BottomNavScreen

@Composable
fun CustomBottomBar(
    items: List<BottomNavScreen>,
    currentScreenId: String,
    onItemSelected: (BottomNavScreen) -> Unit
) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 8.dp, vertical = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { item ->
            Log.e("TAG", "CustomBottomBar: item route = ${item.route}", )
            Log.e("TAG", "CustomBottomBar: currentscreen route = ${currentScreenId}", )
            CustomBottomBarItem(item = item, isSelected = item.route == currentScreenId) {
                onItemSelected(item)
            }
        }
    }
}

@Composable
fun CustomBottomBarItem(
    item: BottomNavScreen,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val background = if (isSelected) Color.White else Color.Transparent
    val contentColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.White

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(color = background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(if (isSelected) item.iconFocused else item.icon),
                contentDescription = null,
                tint = contentColor
            )
            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = stringResource(item.title),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                    color = contentColor
                )
            }
        }
    }
}
