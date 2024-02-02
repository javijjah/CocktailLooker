package com.hachatml.cocktaillooker.Model

class CocktailCargado {
    /**
     * Singleton que le da acceso a toda la app sobre el Cocktail que tenemos cargado en ese momento.
     */
    data object CocktailCargado {
        var CocktailActivo:Cocktail? = null
    }
}