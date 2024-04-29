package com.apps.todoapp.presentation.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.apps.todoapp.R

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    labelText: String = "",
    errorMessage: String? = null,
    isFocusChange: ((Boolean) -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    onTextChange: ((String) -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isReadOnly: Boolean = false,
    onClick: ((Boolean) -> Unit)? = null,
    value: String? = null,
    isSingleLine: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null
    ) {
        val customTextFieldColors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            errorContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.outlineVariant,
            errorLabelColor = MaterialTheme.colorScheme.error,
            errorTextColor = MaterialTheme.colorScheme.error,
            errorTrailingIconColor = MaterialTheme.colorScheme.error,
            cursorColor = MaterialTheme.colorScheme.tertiary,
            errorCursorColor = MaterialTheme.colorScheme.error,
            focusedTextColor = MaterialTheme.colorScheme.primary,
            unfocusedTextColor = MaterialTheme.colorScheme.primary
        )
        var textChange by remember { mutableStateOf("") }
        val interactionSource = remember { MutableInteractionSource() }
        val isFocused = interactionSource.collectIsFocusedAsState()
        val isPressed = interactionSource.collectIsPressedAsState()

        LaunchedEffect(isFocused.value) {
            if (isFocusChange != null) {
                isFocusChange(isFocused.value)
            }
        }

        LaunchedEffect(isPressed.value) {
            if (onClick != null && isFocused.value) {
                onClick(isPressed.value)
            }
        }

        Column {
            TextField(
                readOnly = isReadOnly,
                modifier = (modifier)
                    .fillMaxWidth()
                    .border(
                        border = BorderStroke(
                            1.5.dp,
                            when {
                                !errorMessage.isNullOrEmpty() -> {
                                    MaterialTheme.colorScheme.onErrorContainer
                                }

                                isFocused.value && errorMessage.isNullOrEmpty() -> {
                                    MaterialTheme.colorScheme.primary
                                }

                                else -> MaterialTheme.colorScheme.secondary
                            }
                        ), shape = RoundedCornerShape(8.dp)
                    ),
                textStyle = MaterialTheme.typography.bodyMedium,
                value = value ?: textChange,
                singleLine = isSingleLine,
                isError = !errorMessage.isNullOrEmpty(),
                colors = customTextFieldColors,
                trailingIcon = trailingIcon,
                leadingIcon = leadingIcon,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType
                ),
                visualTransformation = visualTransformation,
                onValueChange = {
                    textChange = it
                    if (onTextChange != null) {
                        onTextChange(it)
                    }
                },
                interactionSource = interactionSource,
                label = { Text(text = labelText) }
            )

            if (!errorMessage.isNullOrEmpty()) {
                Text(
                    text = errorMessage,
                    style = MaterialTheme.typography.bodySmall.copy(MaterialTheme.colorScheme.error)
                )
            }
        }
    }

    @Composable
    fun PasswordIcon(onClick: (Boolean) -> Unit) {
        var iconState by remember { mutableStateOf(false) }
        IconButton(onClick = {
            iconState = !iconState
            onClick(iconState)
        }) {
            Icon(
                painterResource(id = if (iconState) R.drawable.ic_visibility_off else R.drawable.ic_visibility),
                contentDescription = "Visibility",
                tint = MaterialTheme.colorScheme.surfaceTint
            )
        }
    }