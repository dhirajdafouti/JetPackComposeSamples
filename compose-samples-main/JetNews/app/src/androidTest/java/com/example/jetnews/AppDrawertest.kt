package com.example.jetnews

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertIsNotSelected
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.jetnews.ui.AppDrawer
import com.example.jetnews.ui.JetnewsDestinations
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppDrawerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun AppDrawer_displaysHomeAndInterests() {
        composeTestRule.setContent {
            AppDrawer(
                drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
                currentRoute = JetnewsDestinations.HOME_ROUTE,
                navigateToHome = {},
                navigateToInterests = {},
                closeDrawer = {}
            )
        }

        composeTestRule.onNodeWithText("Home").assertIsDisplayed()
        composeTestRule.onNodeWithText("Interests").assertIsDisplayed()
    }

    @Test
    fun AppDrawer_homeSelected() {
        composeTestRule.setContent {
            AppDrawer(
                drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
                currentRoute = JetnewsDestinations.HOME_ROUTE,
                navigateToHome = {},
                navigateToInterests = {},
                closeDrawer = {}
            )
        }

        composeTestRule.onNodeWithText("Home").assertIsSelected()
        composeTestRule.onNodeWithText("Interests").assertIsNotSelected()
    }

    @Test
    fun AppDrawer_interestsSelected() {
        composeTestRule.setContent {
            AppDrawer(
                drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
                currentRoute = JetnewsDestinations.INTERESTS_ROUTE,
                navigateToHome = {},
                navigateToInterests = {},
                closeDrawer = {}
            )
        }

        composeTestRule.onNodeWithText("Home").assertIsNotSelected()
        composeTestRule.onNodeWithText("Interests").assertIsSelected()
    }

    @Test
    fun AppDrawer_navigateToHome() {
        var homeClicked = false
        var drawerClosed = false

        composeTestRule.setContent {
            AppDrawer(
                drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
                currentRoute = JetnewsDestinations.INTERESTS_ROUTE,
                navigateToHome = { homeClicked = true },
                navigateToInterests = {},
                closeDrawer = { drawerClosed = true }
            )
        }

        composeTestRule.onNodeWithText("Home").performClick()
        assert(homeClicked)
        assert(drawerClosed)
    }

    @Test
    fun AppDrawer_navigateToInterests() {
        var interestsClicked = false
        var drawerClosed = false

        composeTestRule.setContent {
            AppDrawer(
                drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
                currentRoute = JetnewsDestinations.HOME_ROUTE,
                navigateToHome = {},
                navigateToInterests = { interestsClicked = true },
                closeDrawer = { drawerClosed = true }
            )
        }

        composeTestRule.onNodeWithText("Interests").performClick()
        assert(interestsClicked)
        assert(drawerClosed)
    }
}