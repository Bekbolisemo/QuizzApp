package com.example.quizzapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizzapp.domain.main.entity.TriviaCategory
import com.example.quizzapp.domain.main.usecases.GetCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val getCategoryUseCase: GetCategoryUseCase):ViewModel() {

    private val _categoryList = MutableStateFlow<List<TriviaCategory>>(mutableListOf())

    val categoryList:StateFlow<List<TriviaCategory>> get() = _categoryList

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            getCategoryUseCase.invoke()
                .onStart {
                    //loading
                }
                .catch {
                    //hideload
                    // message error
                }
                .collect{
                    _categoryList.value = it

                }
        }
    }
}