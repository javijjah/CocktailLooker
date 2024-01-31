package com.hachatml.cocktaillooker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hachatml.cocktaillooker.NavHost.Routes
import com.hachatml.cocktaillooker.Screens.BebidaCargadaScreen
import com.hachatml.cocktaillooker.Screens.RandomButtonScreen
import com.hachatml.cocktaillooker.ui.theme.CocktailLookerTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CocktailLookerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.BotonRandom.route
                    ) {
                        composable(Routes.BotonRandom.route) { RandomButtonScreen(navController) }
                        composable(Routes.BebidaCargada.route) { BebidaCargadaScreen(navController) }
                    }
                }
            }
        }
    }
}
