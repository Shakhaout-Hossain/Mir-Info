package com.example.mirinfo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mirinfo.ui.screens.HomeScreen
import com.example.mirinfo.ui.login.LoginPage
import com.example.mirinfo.ui.login.SignUpPage
import com.example.mirinfo.ui.screens.listView.BookDetailsScreen
import com.example.mirinfo.ui.screens.listView.BookListScreen
import com.example.mirinfo.ui.screens.FormScreen
import com.example.mirinfo.ui.screens.splash.SplashScreen
import com.example.mirinfo.ui.screens.tabView.TabViewScreen
import com.example.mirinfo.viewModel.*

@Composable
fun Navigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel, bookViewModel: BookViewModel = viewModel()) {
    val navController = rememberNavController()
    val formViewModel = FormViewModel()
    
    NavHost(navController = navController, startDestination = "splash_screen", builder = {
        composable("splash_screen") {
            SplashScreen( navController = navController)
        }
        composable("login") {
            LoginPage(modifier, navController, authViewModel)
        }
        composable("signup") {
            SignUpPage(modifier, navController, authViewModel)
        }
//        composable("verifyEmail") {
//            EmailVerificationScreen(authViewModel) {
//                navController.navigate("home") {
//                    popUpTo("verifyEmail") { inclusive = true }
//                }
//            }
//        }
        composable("home") {
            HomeScreen(modifier, navController, authViewModel)
        }
        composable("form") {
            FormScreen(modifier, navController, formViewModel )
        }
        composable("tabs") {
            TabViewScreen(modifier, navController = navController)
        }
        composable("book_list") {
            BookListScreen(
                onBookClick = { book ->
                    bookViewModel.selectBook(book)
                    navController.navigate("book_details")
                }
            )
        }
        composable("book_details") {
            BookDetailsScreen(
                book = bookViewModel.selectedBook.value,
                onBack = { navController.popBackStack() }
            )
        }
    })
}