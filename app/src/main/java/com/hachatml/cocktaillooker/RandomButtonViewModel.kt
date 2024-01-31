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

class RandomButtonViewModel : ViewModel() {
    private val cocktailApiService = RetrofitInstance.RetrofitInstance.api
    var isLoading by mutableStateOf(false)
    var Cocktails: MutableState<List<Cocktail>> = mutableStateOf(emptyList())
    fun getCocktail() {
        viewModelScope.launch {
            try {
                val response = cocktailApiService.getRandomCocktail()
                CocktailCargado.CocktailCargado.CocktailActivo = response.drinks[0]
                println("Datos de la API recogidos correctamente")
            } catch (e: Exception) {
                println("ERROR al recoger datos de la API")
                e.printStackTrace()
            }
        }
    }

    fun RandomButtonPressed(navController: NavController) {
        viewModelScope.launch {
            getCocktail()
            isLoading = true
            delay(3000)
            isLoading = false
            navController.navigate(Routes.BebidaCargada.route)
        }
    }
}