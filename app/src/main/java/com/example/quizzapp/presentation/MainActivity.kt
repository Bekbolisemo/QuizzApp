package com.example.quizzapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BlockedNumberContract
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.quizzapp.R
import com.example.quizzapp.databinding.ActivityMainBinding
import com.example.quizzapp.domain.main.entity.TriviaCategory
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivityMainBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainFragment, R.id.secondFragment, R.id.thirdFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        initObservers()

    }

    private fun initObservers() {
        viewModel.categoryList.flowWithLifecycle(lifecycle, Lifecycle.State.CREATED)
            .onEach {
                handleCategories(it)
            }.launchIn(lifecycleScope)
    }

    private fun handleCategories(list: List<TriviaCategory>) {
        Log.e("cat", "$list")
    }
}