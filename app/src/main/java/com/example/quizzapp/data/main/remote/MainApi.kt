package com.example.quizzapp.data.main.remote

import androidx.room.Query
import com.example.quizzapp.domain.main.entity.CategoriesResponseEntity
import retrofit2.Response
import retrofit2.http.GET

interface MainApi {
  @GET("api_categories.php")
   suspend fun getCategories(): Response<CategoriesResponseEntity>
}