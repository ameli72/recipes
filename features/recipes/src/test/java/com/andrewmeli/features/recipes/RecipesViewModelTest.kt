package com.andrewmeli.features.recipes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.andrewmeli.features.util.getOrAwaitValue
import com.andrewmeli.libraries.repository.FakeRepository
import com.andrewmeli.libraries.repository.others.Status
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RecipesViewModelTest {

    private lateinit var viewModel: RecipesViewModel

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        viewModel = RecipesViewModel(FakeRepository())
    }

    @Test
    fun getRecipesChicken_returnsFour() {
        // When adding a new task
        viewModel.getRecipes("chicken")

        // await result
        val value = viewModel.recipes.getOrAwaitValue()

        assertEquals(value.peekContent().status, Status.SUCCESS)
        assertEquals(value.peekContent().data?.count(), 4)
    }


    @Test
    fun getRecipesQuail_returnsZero() {
        // When adding a new task
        viewModel.getRecipes("quail")

        // await result
        val value = viewModel.recipes.getOrAwaitValue()

        assertEquals(value.peekContent().status, Status.SUCCESS)
        assertEquals(value.peekContent().data?.count(), 0)
    }


    @Test
    fun getRecipes_clearRecipes_returnsZero() {
        // When adding a new task
        viewModel.getRecipes("chicken")

        // await result
        var value = viewModel.recipes.getOrAwaitValue()

        assertEquals(value.peekContent().status, Status.SUCCESS)
        assertEquals(value.peekContent().data?.count(), 4)

        //Now clear result
        viewModel.clearRecipes()

        // await result
        value = viewModel.recipes.getOrAwaitValue()

        assertEquals(value.peekContent().status, Status.SUCCESS)
        assertEquals(value.peekContent().data?.count(), 0)
    }
}