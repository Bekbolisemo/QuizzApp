package com.example.quizzapp.domain.main.entity


import com.google.gson.annotations.SerializedName

data class CategoriesResponseEntity(
    @SerializedName("trivia_categories")
    val triviaCategories: List<TriviaCategory>
)
    data class TriviaCategory(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?
    )
