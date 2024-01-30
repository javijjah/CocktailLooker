package com.hachatml.cocktaillooker.Screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.hachatml.cocktaillooker.RandomButtonViewModel

@Composable
fun RandomButtonScreen() {
    var VM = RandomButtonViewModel()
    Text(text = "¿Nos bebemos algo, máquina?")
    Button(onClick = { VM.RandomButtonPressed() }) {
        Text(text = "Ofréceme")
    }
}