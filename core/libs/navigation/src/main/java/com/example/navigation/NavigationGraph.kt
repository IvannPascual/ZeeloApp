package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun NavigationGraph(
    navController: NavHostController,
    bookListScreen: @Composable () -> Unit,
    addNewBookScreen: @Composable () -> Unit,
    bookDetailScreen: @Composable (Long) -> Unit,

) {
    NavHost(navController, startDestination = Screen.BookList.route) {
        composable(Screen.BookList.route) {
            bookListScreen.invoke()

        }
        composable(Screen.AddNewBook.route) {
           addNewBookScreen.invoke()
        }
        composable(
            route = Screen.BookDetail.route,
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val bookId = arguments.getLong("id")
            bookDetailScreen.invoke(bookId)
        }
    }
}