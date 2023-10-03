package com.example.zeelo

import androidx.activity.compose.setContent
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.common.domain.booklist.GetBooksUseCase
import com.example.zeelo.core.libs.testfixtures.BookFakeDataRepository
import com.example.zeelo.core.libs.testfixtures.BookFakeDataRepository.Companion.emptyBooks
import com.example.zeelo.core.libs.testfixtures.BookFakeDataRepository.Companion.twoBooks
import com.example.zeelo.features.booklist.ui.BookListTestTags.bookListViewTestTag
import com.example.zeelo.features.booklist.ui.BookListTestTags.noBooksErrorTestTag
import com.example.zeelo.features.booklist.ui.mvi.BookListViewModel
import com.example.zeelo.features.booklist.ui.screens.BookListScreen
import com.example.zeelo.ui.theme.ZeeloTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChargerListUiTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun `GIVEN_two_books_THEN_the_view_contain_the_expected_items`() {
        val viewModel = BookListViewModel(
            GetBooksUseCase(
                BookFakeDataRepository(twoBooks)
            )
        )
        composeTestRule.activity.setContent {
            ZeeloTheme {
                BookListScreen(viewModel, navigateToDetail = {})
            }
        }

        composeTestRule.onNodeWithTag(bookListViewTestTag)
            .onChildren().assertCountEquals(2)
    }

    @Test
    fun `GIVEN_no_items_THEN_the_view_contain_the_error_view`() {
        val viewModel = BookListViewModel(
            GetBooksUseCase(
                BookFakeDataRepository(emptyBooks)
            )
        )
        composeTestRule.activity.setContent {
            ZeeloTheme {
                BookListScreen(viewModel, navigateToDetail = {})
            }
        }
        composeTestRule.onNodeWithTag(noBooksErrorTestTag)
    }
}


