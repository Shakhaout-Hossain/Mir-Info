package com.example.mirinfo.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FormViewModel : ViewModel() {
    var name by mutableStateOf("")
        private set

    var email by mutableStateOf("")
        private set

    var age by mutableStateOf("")
        private set

    var selectedGender by mutableStateOf("Select Gender")
        private set

    val genders = listOf("Male", "Female", "Other")

    var isSubmitted by mutableStateOf(false)
        private set

    fun onNameChange(newName: String) {
        name = newName
    }

    fun onEmailChange(newEmail: String) {
        email = newEmail
    }

    fun onAgeChange(newAge: String) {
        age = newAge
    }

    fun onGenderChange(newGender: String) {
        selectedGender = newGender
    }

    fun submitForm() {
        isSubmitted = true
    }
}