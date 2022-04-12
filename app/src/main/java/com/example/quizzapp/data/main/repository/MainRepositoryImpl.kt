package com.example.quizzapp.data.main.repository

import android.util.Log
import androidx.room.Index
import com.example.quizzapp.data.main.remote.MainApi
import com.example.quizzapp.domain.main.MainRepository
import com.example.quizzapp.domain.main.entity.TriviaCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor ( private val mainApi: MainApi):MainRepository {

    override suspend fun getCategories(): Flow<List<TriviaCategory>> {

        return flow {
            val response = mainApi.getCategories()
            if (response.isSuccessful){
                val body = response.body()
                body?.let { emit(it.triviaCategories) }
            }else{
               // Log.e(TAG, "getCategories: ", ) error
            }
        }
    }
}