package com.hachatml.cocktaillooker.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstance {
    object RetrofitInstance{
        private const val BASE_URL = "https://www.thecocktaildb.com/api/"
        val api: CocktailApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(CocktailApiService::class.java)
        }
    }
}