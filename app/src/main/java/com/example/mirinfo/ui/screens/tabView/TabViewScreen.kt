package com.example.mirinfo.ui.screens.tabView


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabViewScreen( modifier: Modifier = Modifier, navController: NavController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabItems = listOf("Google", "Apple", "Amazon")
    val tabNavController = rememberNavController()

//    // Handle back button press
//    BackHandler {
//        if (selectedTabIndex > 0) {
//            selectedTabIndex -= 1 // Go to previous tab
//            tabNavController.navigate(
//                when (selectedTabIndex) {
//                    0 -> "Google"
//                    1 -> "Apple"
//                    else -> "Google"
//                }
//            ) {
//                popUpTo("Google") { inclusive = false }
//            }
//        } else {
//            navController.navigate("home") { // Navigate to home screen
//                popUpTo("home") { inclusive = true }
//            }
//            //navController.popBackStack() // Exit the TabViewScreen
//        }
//    }


    Scaffold(
        topBar = {
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = MaterialTheme.colorScheme.primaryContainer, // Updated property
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer // Updated property
            ) {
                tabItems.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                            tabNavController.navigate(
                                when (index) {
                                    0 -> "Google"
                                    1 -> "Apple"
                                    2 -> "Amazon"
                                    else -> "Google"
                                }
                            )
                        },
                        text = {
                            Text(
                                text = title,
                                color = MaterialTheme.colorScheme.onPrimaryContainer // Direct text color
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = tabNavController,
            startDestination = "Google",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("Google") { TabContent1(navController) }
            composable("Apple") { TabContent2(navController) }
            composable("Amazon") { TabContent3(navController) }
        }
    }
}
