package com.example.quizzapp.di.network

import androidx.room.Index
import com.example.quizzapp.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BASE_URL).build()
    }

}