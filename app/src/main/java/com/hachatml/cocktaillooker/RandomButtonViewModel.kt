package com.hachatml.cocktaillooker

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.hachatml.cocktaillooker.Model.Cocktail
import com.hachatml.cocktaillooker.Model.CocktailApiService
import com.hachatml.cocktaillooker.Model.CocktailCargado
import com.hachatml.cocktaillooker.Model.RetrofitInstance
import com.hachatml.cocktaillooker.NavHost.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * El ViewModel de nuestra app
 */
class RandomButtonViewModel : ViewModel() {
    //Nuestra instancia de Retrofit
    private val cocktailApiService = RetrofitInstance.RetrofitInstance.api
    //Gestión de la pantalla de carga
    var isLoading by mutableStateOf(false)
    var Cocktails: MutableState<List<Cocktail>> = mutableStateOf(emptyList())
    fun getCocktail() {
        viewModelScope.launch {
            try {
                //respuesta de la API recogida en esta variable
                val response = cocktailApiService.getRandomCocktail()
                //Aplicamos al Singleton la información del primer resultado, ya que
                //en este caso sólo obtenemos 1 aleatorio.
                CocktailCargado.CocktailCargado.CocktailActivo = response.drinks[0]
                println("Datos de la API recogidos correctamente")
            } catch (e: Exception) {
                println("ERROR al recoger datos de la API")
                e.printStackTrace()
            }
        }
    }
    //Acción del botón y carga de la pantalla siguiente
    fun RandomButtonPressed(navController: NavController) {
        viewModelScope.launch {
            isLoading = true
            getCocktail()
            delay(1000)
            isLoading = false
            navController.navigate(Routes.BebidaCargada.route)
        }
    }
}