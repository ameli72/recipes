package com.andrewmeli.recipes

import android.view.KeyEvent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.andrewmeli.features.recipes.RecipesActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RecipesActivityTest {
    @get:Rule
    val activityRule = ActivityTestRule(RecipesActivity::class.java, false, false)


    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(RecipesActivity::class.java)
    }

    @Test
    fun onLaunchCheckTitleIsDisplayed() {
        ActivityScenario.launch(RecipesActivity::class.java)

        onView(withId(com.andrewmeli.features.recipes.R.id.textViewTitle))
            .check(matches(isDisplayed()))
    }

    @Test
    fun onLaunchTitleTextIsOkay() {
        ActivityScenario.launch(RecipesActivity::class.java)

        onView(withText(com.andrewmeli.features.recipes.R.string.search_phase))
            .check(matches(isDisplayed()))
    }

    @Test
    fun onLaunchCheckSearchViewIsDisplayed() {
        ActivityScenario.launch(RecipesActivity::class.java)

        onView(withId(com.andrewmeli.features.recipes.R.id.searchView))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkEnteringSearchPhaseWorks() {
        ActivityScenario.launch(RecipesActivity::class.java)

        onView(withId(androidx.appcompat.R.id.search_button)).perform(click())
        onView(withId(androidx.appcompat.R.id.search_src_text)).perform(
            typeText("chicken"),
            pressKey(KeyEvent.KEYCODE_ENTER)
        )
    }
}
