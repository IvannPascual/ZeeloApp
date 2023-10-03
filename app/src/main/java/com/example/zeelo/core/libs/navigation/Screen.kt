package com.example.zeelo.core.libs.navigation

sealed class Screen(val route: String) {
    data object BookList : Screen(route = "BookList")
    data object BookDetail : Screen(route = "BookDetail/{id}")
    data object AddNewBook : Screen(route = "AddNewBook")
}