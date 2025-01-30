package com.example.mirinfo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mirinfo.viewModel.FormViewModel

@Composable
fun FormScreen(modifier: Modifier = Modifier, navController: NavController, viewModel: FormViewModel) {
    val name = viewModel.name
    val email = viewModel.email
    val age = viewModel.age
    val selectedGender = viewModel.selectedGender
    val genders = viewModel.genders

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("User Form", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Name Field
        OutlinedTextField(
            value = name,
            onValueChange = viewModel::onNameChange,
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = viewModel::onEmailChange,
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Age Field
        OutlinedTextField(
            value = age,
            onValueChange = viewModel::onAgeChange,
            label = { Text("Age") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Gender Dropdown
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(selectedGender)
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                genders.forEach { gender ->
                    DropdownMenuItem(
                        text = { Text(gender) },
                        onClick = {
                            viewModel.onGenderChange(gender)
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Submit Button
        Button(
            onClick = viewModel::submitForm,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display Submitted Info
        if (viewModel.isSubmitted) {
            Text("Submitted Information:")
            Text("Name: ${viewModel.name}")
            Text("Email: ${viewModel.email}")
            Text("Age: ${viewModel.age}")
            Text("Gender: ${viewModel.selectedGender}")
        }
    }
}