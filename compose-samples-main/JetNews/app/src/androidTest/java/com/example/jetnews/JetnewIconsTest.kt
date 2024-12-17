package com.example.jetnews

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.jetnews.ui.MainActivity
import com.example.jetnews.ui.utils.FavoriteButton
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JetnewIconsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testFavoriteButton() {
        var clicked = false
        composeTestRule.setContent {
            FavoriteButton(onClick = { clicked = true })
        }

        composeTestRule.onNodeWithContentDescription("Add to favorites")
            .performClick()

        assert(clicked)
    }

}
