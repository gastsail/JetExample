package com.example.jetexample.data.model

import androidx.annotation.DrawableRes

// [EN] We define a data class that will hold the data of each row
// [ES] Definimos un data class que contiene los elementos de la receta
data class Recipe(
        @DrawableRes val imageResource: Int,
        val title: String,
        val ingredients: List<String>
)