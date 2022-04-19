package com.example.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiModule {

    @Binds
    abstract fun bindProductsApiService(service: ApiService): com.example.usecase.ProductsApi

    companion object {

        @Provides
        fun provideProductsApi(retrofit: Retrofit): ProductsApi {
            return retrofit.create(ProductsApi::class.java)
        }

        @Provides
        fun provideGson(): Gson {
            return GsonBuilder().setLenient()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        }

        @Singleton
        @Provides
        fun provideProductsRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}