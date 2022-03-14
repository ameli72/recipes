package com.andrewmeli.features.recipes

import androidx.lifecycle.*
import com.andrewmeli.features.recipes.di.IRecipesViewModel
import com.andrewmeli.libraries.model.Recipe
import com.andrewmeli.libraries.repository.IRepository
import com.andrewmeli.libraries.repository.others.Event
import com.andrewmeli.libraries.repository.others.Resource
import com.andrewmeli.libraries.repository.others.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RecipesViewModel
@Inject constructor(private val repository: IRepository) :
    IRecipesViewModel, ViewModel(), LifecycleObserver {
    private val _recipes: MutableLiveData<Event<Resource<List<Recipe>>>> =
        MutableLiveData()
    override val recipes: LiveData<Event<Resource<List<Recipe>>>>
        get() = _recipes


    override fun getRecipes(searchPhase: String) {
        if (searchPhase.isNotEmpty())
            viewModelScope.launch {
                repository.getRecipes(searchPhase)
                    .onEach { _recipes.value = Event(it) }
                    .launchIn(viewModelScope)
            }
    }

    override fun clearRecipes() {
        _recipes.value = Event(Resource(Status.SUCCESS, listOf(), null))
    }
}
