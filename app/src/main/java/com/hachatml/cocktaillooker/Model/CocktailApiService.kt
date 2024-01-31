package com.hachatml.cocktaillooker.Model

import retrofit2.http.GET

interface CocktailApiService {
    @GET("json/v1/1/random.php")
    suspend fun getRandomCocktail(): CocktailResponse
}