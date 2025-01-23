package com.example.mirinfo.ui.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.mirinfo.viewModel.AuthState
import com.example.mirinfo.viewModel.AuthViewModel
import com.example.mirinfo.R


@Composable
fun LoginPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value){
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("home")
            is AuthState.Error -> Toast.makeText(
                context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login With Email", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(text = "Email")
            },
            trailingIcon = {
                val gifPainter: Painter = rememberAsyncImagePainter(model = R.drawable.email)
                Image(
                    painter = gifPainter,
                    contentDescription = "Email icon",
                    modifier = Modifier.size(32.dp)
                )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = "Password")
            },
            trailingIcon = {
                val gifPainter: Painter = rememberAsyncImagePainter(model = R.drawable.password)
                Image(
                    painter = gifPainter,
                    contentDescription = "Password icon",
                    modifier = Modifier.size(32.dp)
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Login Button
        Button(
            onClick = {

                // Handle login logic here
                authViewModel.login(email, password) // Example login method in ViewModel
                //navController.navigate("home")
                },
            enabled = authState.value != AuthState.Loading,
            modifier = Modifier
                //.fillMaxWidth(0.8f) // Adjust width relative to the screen
                .height(50.dp),    // Set a fixed height for the button
        ) {
            Text(text = "Login", fontSize = 18.sp)
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        TextButton(onClick = {
            navController.navigate("signup")
        }) {
            Text(text = "Don't have an account? Signup")
            
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLoginPage() {
    // Mock values for preview
//    val mockNavController = rememberNavController()
//    val mockAuthViewModel = AuthViewModel() // Replace with your mocked or default AuthViewModel implementation
//
//    LoginPage(
//        navController = mockNavController,
//        authViewModel = mockAuthViewModel
//    )
}
