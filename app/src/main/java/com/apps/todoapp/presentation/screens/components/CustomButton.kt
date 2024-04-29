package com.apps.todoapp.presentation.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
) {
    val buttonColor = ButtonDefaults.buttonColors(
        containerColor = containerColor,
    )
    Button(
        modifier = (modifier)
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = buttonColor,
        onClick = { onClick() }) {
        FilledButtonText(
            buttonText = buttonText
        )
    }
}
@Composable
fun FilledButtonText(buttonText: String) {
    Text(
        text = buttonText,
        style = MaterialTheme.typography.bodyLarge.copy(
            color = MaterialTheme.colorScheme.background,
            fontWeight = FontWeight.SemiBold
        )
    )
}