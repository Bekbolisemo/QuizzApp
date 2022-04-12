package com.example.quizzapp.domain.main.usecases

import com.example.quizzapp.domain.main.MainRepository
import javax.inject.Inject


class GetCategoryUseCase @Inject constructor(private val mainRepository: MainRepository) {

    suspend fun invoke() = mainRepository.getCategories()
}