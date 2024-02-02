package com.hachatml.cocktaillooker.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * Nuestra instancia de Retrofit, la cual debe ser un Singleton
 */
class RetrofitInstance {
    object RetrofitInstance{
        //El URL base de la API que usaremos
        private const val BASE_URL = "https://www.thecocktaildb.com/api/"
        //La conexión a la interfaz que hemos creado, con sus atributos.
        val api: CocktailApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                //este es nuestro gestor de JSON, Gson, creado por Google
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(CocktailApiService::class.java)
        }
    }
}