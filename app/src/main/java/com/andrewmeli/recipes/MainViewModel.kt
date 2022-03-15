package com.andrewmeli.recipes

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andrewmeli.recipes.di.IMainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor() : IMainViewModel, ViewModel(), LifecycleObserver {

    private val _timerCompleted = MutableLiveData(false)
    override val timerCompleted: LiveData<Boolean>
        get() = _timerCompleted


    init {
        startHandler()
    }

    private fun startHandler() {
        Handler(Looper.getMainLooper()).postDelayed({
            _timerCompleted.postValue(true)
        }, SPLASH_SCREEN_MILLISECONDS)
    }

    companion object {
        const val SPLASH_SCREEN_MILLISECONDS = 2000L
    }
}