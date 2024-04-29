package com.apps.todoapp.presentation.screens.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GenderDropdown(
    selectedGender: String,
    onGenderSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var gender by remember { mutableStateOf(selectedGender) }
    Column {
        CustomTextField(
            labelText = "Gender",
            value = gender,
            onTextChange = {
                gender = it
            },
            isReadOnly = true
        )

        Box {
            TextButton(
                onClick = { expanded = true },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Select Gender")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Male")}, onClick = {
                    onGenderSelected("Male")
                        gender = "Male"
                    expanded = false
                })
                DropdownMenuItem(text = { Text(text = "Female")} ,onClick = {
                    onGenderSelected("Female")
                    gender = "Female"
                    expanded = false
                })
            }
        }
    }
}
