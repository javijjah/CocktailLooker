package com.hachatml.cocktaillooker.Model

import retrofit2.http.GET

/**
 * Gestiona las funciones que queramos crear, introduciendo las HTTP request que deseemos
 * entre los metadatos y comunicándolo a Retrofit.
 */
interface CocktailApiService {
    @GET("json/v1/1/random.php")
    suspend fun getRandomCocktail(): CocktailResponse
}