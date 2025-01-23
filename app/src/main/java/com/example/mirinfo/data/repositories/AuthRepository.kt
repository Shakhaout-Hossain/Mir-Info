package com.example.mirinfo.data.repositories

import com.example.mirinfo.data.services.FirebaseAuthService

class AuthRepository(private val firebaseAuthService: FirebaseAuthService) {
    fun sendVerificationEmail(onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        firebaseAuthService.sendEmailVerification(onSuccess, onFailure)
    }

    fun checkEmailVerification(onResult: (Boolean) -> Unit) {
        firebaseAuthService.isEmailVerified (onResult)
    }
}
