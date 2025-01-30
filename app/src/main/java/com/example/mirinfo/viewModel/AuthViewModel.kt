package com.example.mirinfo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mirinfo.data.repositories.AuthRepository
import com.google.firebase.auth.FirebaseAuth


class AuthViewModel(/*private val authRepository: AuthRepository*/): ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    init {
        checkAuthState()
    }

    fun checkAuthState() {
        if(auth.currentUser == null){
            _authState.value = AuthState.Unauthenticated
        } else {
            _authState.value = AuthState.Authenticated
        }
    }

    fun login(email: String, password: String) {

        if(email.isEmpty() || password.isEmpty()){
            _authState.value = AuthState.Error("Email or Password can't be Empty")
            return
        }

        _authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{task->
                if(task.isSuccessful){
                    _authState.value = AuthState.Authenticated
                }else{
                    _authState.value =
                        AuthState.Error(task.exception?.message ?: "Something Went Wrong")
                }
            }
    }

    fun signup(email: String, password: String) {

        //println(email + " " + password)

        if(email.isEmpty() || password.isEmpty()){
            _authState.value = AuthState.Error("Email or Password can't be Empty")
            return
        }

        _authState.value = AuthState.Loading
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{task->
                if(task.isSuccessful){
                    _authState.value = AuthState.Authenticated
                }else{
                    _authState.value =
                        AuthState.Error(task.exception?.message ?: "Something Went Wrong")
                }
            }
    }

    fun signout(){
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
    }

//    fun sendEmailVerification(onSuccess: () -> Unit, onFailure: (String) -> Unit) {0
//        authRepository.sendVerificationEmail(onSuccess, onFailure)
//    }
//
//    fun checkEmailVerification(onResult: (Boolean) -> Unit) {
//        authRepository.checkEmailVerification(onResult)
//    }


}

sealed class AuthState {
    object Authenticated: AuthState()
    object Unauthenticated: AuthState()
    object Loading: AuthState()
    data class Error(val message: String) : AuthState()
}