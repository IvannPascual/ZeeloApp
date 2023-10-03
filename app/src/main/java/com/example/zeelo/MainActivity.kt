package com.example.zeelo

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.example.navigation.NavigationGraph
import com.example.navigation.Screen
import com.example.ui.Dimens.spaceVeryBig
import com.example.zeelo.features.addnewbook.ui.AddNewBookScreen
import com.example.zeelo.features.bookdetail.ui.screens.BookDetailScreen
import com.example.zeelo.features.booklist.ui.screens.BookListScreen
import com.example.zeelo.ui.theme.ZeeloTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
    @RequiresApi(Build.VERSION_CODES.S)
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            ZeeloTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(stringResource(id = R.string.app_name)) }
                        )
                    },
                    content = { innerPadding ->
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(PaddingValues(top = spaceVeryBig))
                                .consumeWindowInsets(paddingValues = innerPadding),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            NavigationGraph(
                                navController,
                                bookListScreen = {
                                    BookListScreen(
                                        navigateToDetail = {
                                            navController.navigate("BookDetail/$it") {
                                                popUpTo(Screen.BookList.route)
                                            }
                                        }
                                    )
                                },
                                addNewBookScreen = {
                                    AddNewBookScreen(
                                        navBack = {
                                            navController.popBackStack()
                                        }
                                    )
                                },
                                bookDetailScreen = {
                                    BookDetailScreen(it)
                                }
                            )
                        }
                    },
                    floatingActionButton = {
                        ExtendedFloatingActionButton(onClick = {
                            navController.navigate(Screen.AddNewBook.route) {
                                popUpTo(Screen.BookList.route)
                            }
                        }
                        ) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "add book")
                        }
                    }
                )
            }
        }
    }
}


