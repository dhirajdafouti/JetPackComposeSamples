/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetnews

import android.nfc.Tag
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChild
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.printToLog
import androidx.compose.ui.test.printToString
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.jetnews.data.posts.impl.manuel
import com.example.jetnews.data.posts.impl.pietro
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalTestApi::class)
@RunWith(AndroidJUnit4::class)
class JetnewsTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        // Using targetContext as the Context of the instrumentation code
        composeTestRule.launchJetNewsApp(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun app_launches() {
        composeTestRule.onRoot(useUnmergedTree = true).printToLog("TAG")
        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.home_top_section_title))
            .assertExists()

        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.home_search))
            .isNotDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.app_name))
            .isDisplayed()
        composeTestRule.onRoot().printToString()
    }

    @Test
    fun app_opensArticle() {

        println("Debug Article" + composeTestRule.onRoot().printToString())
        composeTestRule.onAllNodes(hasText(pietro.name, substring = true))[0].performClick()

        println("Debug Article" + composeTestRule.onRoot().printToString())
        composeTestRule.onNodeWithContentDescription("Jetnews Logo").isDisplayed()
        try {
            composeTestRule.onAllNodes(hasText("August 02", substring = true))[0].assertExists()
        } catch (e: AssertionError) {
            println(composeTestRule.onRoot().printToString())
            throw e
        }
    }

    @Test
    fun app_openArticle_testScroll() {
        println("Debug Article" + composeTestRule.onRoot().printToString())
        composeTestRule.onAllNodes(hasText(pietro.name, substring = true))[0].performClick()
        composeTestRule.onAllNodes((hasText("August 02", substring = true)))[0].assertExists().performScrollTo().assertExists("Resource")
    }

    @Test
    fun app_opensInterests() {
        composeTestRule.onNodeWithContentDescription(
            label = "Open navigation drawer",
            useUnmergedTree = true
        ).performClick()
        composeTestRule.onNodeWithText("Interests").performClick()
        composeTestRule.waitUntilAtLeastOneExists(hasText("Topics"), 5000L)
    }
}
