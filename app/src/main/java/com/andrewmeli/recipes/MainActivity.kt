package com.andrewmeli.recipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.andrewmeli.libraries.actions.Actions
import com.andrewmeli.recipes.di.IMainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.system.exitProcess


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: IMainViewModel

    private val resultLauncherHome =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { _ ->
            finish()
            exitProcess(0)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
    }

    private fun initViewModel() {
        viewModel.apply {
            timerCompleted.observe(this@MainActivity) { timerCompleted ->
                if (timerCompleted)
                    resultLauncherHome.launch(Actions.openRecipesIntent(this@MainActivity))
            }
        }
    }
}