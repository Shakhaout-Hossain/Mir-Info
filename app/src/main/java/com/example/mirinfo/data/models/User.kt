package com.example.mirinfo.data.models

data class UserInfo (
    val uid: String = "",          // Firebase User ID
    val name: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val isEmailVerified: Boolean = false
)