package com.example.api

import retrofit2.http.GET

interface ProductsApi {

    @GET("v3/18532d04-e842-402e-ac43-10154fbc1f3e")
    suspend fun getProducts (): ProductsResponese
}