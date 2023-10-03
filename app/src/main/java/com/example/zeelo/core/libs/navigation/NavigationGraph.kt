package com.example.zeelo.core.libs.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.zeelo.features.addnewbook.ui.AddNewBookScreen
import com.example.zeelo.features.bookdetail.ui.screens.BookDetailScreen
import com.example.zeelo.features.booklist.ui.screens.BookListScreen


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.BookList.route) {
        composable(Screen.BookList.route) {
            BookListScreen(
                navController,
                navigateToDetail = {
                    navController.navigate("BookDetail/$it") {
                        popUpTo(Screen.BookList.route)
                    }
                }
            )
        }
        composable(Screen.AddNewBook.route) {
            AddNewBookScreen(
                navBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = Screen.BookDetail.route,
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val bookId = arguments.getLong("id")

            BookDetailScreen(bookId)

        }
    }
}