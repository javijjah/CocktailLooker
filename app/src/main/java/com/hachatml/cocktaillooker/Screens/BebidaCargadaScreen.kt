package com.hachatml.cocktaillooker.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.hachatml.cocktaillooker.Model.CocktailCargado
import com.hachatml.cocktaillooker.Model.CocktailResponse
import com.hachatml.cocktaillooker.RandomButtonViewModel

@Composable
fun BebidaCargadaScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BebidaCargada(viewModel = VM)
    }
}

@Composable
fun BebidaCargada(viewModel: RandomButtonViewModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    AsyncImage(model = CocktailCargado.CocktailCargado.CocktailActivo?.strDrinkThumb, contentDescription = "Imagen Cocktail" )
    CocktailCargado.CocktailCargado.CocktailActivo?.strDrink?.let { Text(text = it) }
    CocktailCargado.CocktailCargado.CocktailActivo?.strInstructions?.let { Text(text = it) }
    }
}