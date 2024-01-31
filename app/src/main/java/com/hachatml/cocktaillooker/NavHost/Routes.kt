package com.hachatml.cocktaillooker.NavHost

sealed class Routes(val route:String) {
    object BotonRandom: Routes("RandomButtonScreen")
    object BebidaCargada: Routes("BebidaCargadaScreen")
}