package com.example.mirinfo.data.services

import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthService {
    private val auth = FirebaseAuth.getInstance()

    fun sendEmailVerification(onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        val user = auth.currentUser
        user?.sendEmailVerification()?.addOnCompleteListener{task ->
            if(task.isSuccessful){
                onSuccess()
            } else {
                onFailure(task.exception?.message?:"Unknown Error")
            }
        }
    }

    fun isEmailVerified(onResult: (Boolean) -> Unit) {
        val user = auth.currentUser
        user?.reload()?.addOnCompleteListener {
            onResult(user.isEmailVerified)
        }
    }
}