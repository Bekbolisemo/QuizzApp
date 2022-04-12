package com.example.quizzapp.domain.main

import com.example.quizzapp.domain.main.entity.TriviaCategory
import kotlinx.coroutines.flow.Flow


interface MainRepository {
    suspend fun getCategories(): Flow<List<TriviaCategory>>
}