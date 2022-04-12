package com.example.quizzapp.di.main

import com.example.quizzapp.data.main.remote.MainApi
import com.example.quizzapp.data.main.repository.MainRepositoryImpl
import com.example.quizzapp.di.network.NetWorkModule
import com.example.quizzapp.domain.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetWorkModule::class])
@InstallIn(SingletonComponent::class)
class MainModule {

    @Singleton
    @Provides
    fun provideMainApi(retrofit: Retrofit):MainApi{
        return retrofit.create(MainApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(mainApi: MainApi):MainRepository{
        return MainRepositoryImpl(mainApi)
    }

}