package com.hachatml.cocktaillooker.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.hachatml.cocktaillooker.RandomButtonViewModel

val VM = RandomButtonViewModel()

@Composable
fun RandomButtonScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!VM.isLoading) {
            Text(text = "¿Nos bebemos algo, máquina?")
            Button(onClick = { VM.RandomButtonPressed(navController) }) {
                Text(text = "Ofréceme")
            }
        } else {
            CircularProgressIndicator()
        }
    }
}

