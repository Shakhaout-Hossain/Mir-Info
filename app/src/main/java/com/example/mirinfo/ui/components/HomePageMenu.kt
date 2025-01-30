package com.example.mirinfo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mirinfo.viewModel.AuthViewModel
import com.example.mirinfo.viewModel.FormViewModel


@Composable
fun HomePageMenu(authViewModel: AuthViewModel, navController: NavController) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Add padding around the layout
            verticalArrangement = Arrangement.spacedBy(16.dp) // Space between rows
        ) {
            // First Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp) // Space between columns
            ) {
                Button(
                    onClick = { /* Handle Button 1 Click */ navController.navigate("book_list") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Book List")
                }
                Button(
                    onClick = {  navController.navigate("tabs") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Tab View")
                }
            }

            // Second Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp) // Space between columns
            ) {
                Button(
                    onClick = { /* Handle Button 3 Click */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Button 3")
                }
                Button(
                    onClick = { /* Handle Button 4 Click */ navController.navigate("form") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "From")
                }
            }

            // Third Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp) // Space between columns
            ) {
                Button(
                    onClick = { authViewModel.signout() },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Log Out")
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    //val mockAuthViewModel = AuthViewModel()
    //HomePageMenu(authViewModel = mockAuthViewModel)
}