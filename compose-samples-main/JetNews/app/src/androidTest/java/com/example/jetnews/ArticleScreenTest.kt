package com.example.jetnews

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.jetnews.data.Result
import com.example.jetnews.data.posts.impl.BlockingFakePostsRepository
import com.example.jetnews.data.posts.impl.post3
import com.example.jetnews.data.posts.impl.post4
import com.example.jetnews.ui.article.ArticleScreen
import com.example.jetnews.ui.theme.JetnewsTheme
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArticleScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun launch_articleScreen() {
        val post = runBlocking {
            (BlockingFakePostsRepository().getPost(post3.id) as Result.Success).data
        }
        composeTestRule.setContent {
            JetnewsTheme {
                ArticleScreen(post, false, {}, false,{})
            }
        }
    }

    @Test
    fun articleScreen_isDisplayingPost() {
        composeTestRule.onNodeWithText(post4.title).assertIsDisplayed()
        composeTestRule.onNodeWithText(post4.metadata.author.name).assertIsDisplayed()
        composeTestRule.onNodeWithText(post4.metadata.date).assertIsDisplayed()
    }

    @Test
    fun articleScreen_isDisplayingButtons() {
        composeTestRule.onNodeWithText("Bookmark").assertIsDisplayed()
        composeTestRule.onNodeWithText("Favorite").assertIsDisplayed()
        composeTestRule.onNodeWithText("Share").assertIsDisplayed()
        composeTestRule.onNodeWithText("Text settings").assertIsDisplayed()
    }

    @Test
    fun articleScreen_toHomeScreen(){
        composeTestRule.onNodeWithText("Navigate back").performClick()
    }


}