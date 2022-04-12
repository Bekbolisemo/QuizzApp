package com.example.quizzapp.domain.model


import com.google.gson.annotations.SerializedName

data class QstResponse(
    @SerializedName("response_code")
    val responseCode: Int?,
    @SerializedName("results")
    val results: List<Qsts?>?
)

    data class Qsts(
        @SerializedName("category")
        val category: String?,
        @SerializedName("correct_answer")
        val correctAnswer: String?,
        @SerializedName("difficulty")
        val difficulty: String?,
        @SerializedName("incorrect_answers")
        val incorrectAnswers: List<String?>?,
        @SerializedName("question")
        val question: String?,
        @SerializedName("type")
        val type: String?
    )
