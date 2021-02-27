package com.example.jetexample.foundation.lazyrowfor

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetexample.ui.typography
import com.example.jetexample.R

/**
 * [EN]
 * In this example will be creating a simple [RecyclerView] of recipes with [LazyColumnFor]
 */

/**
 * [ES]
 * En este ejemplo mostramos como crear un [RecyclerView] de recetas utilizando [LazyColumnFor]
 */

// [EN] We define a data class that will hold the data of each row
// [ES] Definimos un data class que contiene los elementos de la receta
data class Recipe(
        @DrawableRes val imageResource: Int,
        val title: String,
        val ingredients: List<String>
)

// [EN] Creating the dummy list
// [ES] Creamos una lista de prueba
val recipeList = listOf(Recipe(R.drawable.header,"Arrozmate", listOf("Arroz","Tomate","Crema")),
        Recipe(R.drawable.header,"Calabaza", listOf("Queso","Azucar","Agua")),
        Recipe(R.drawable.header,"Torta", listOf("Merengue","Chocolate","Vainilla")),
        Recipe(R.drawable.header,"Torta2", listOf("Merengue2","Chocolate2","Vainilla2")))


// [EN] We define each row of the recyclerview
// [ES] Definimos cada fila del recyclerview
@Composable
private fun RecipeCard(recipe: Recipe){
    val image = painterResource(R.drawable.header)
    Card(shape = RoundedCornerShape(8.dp),elevation = 8.dp,modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            val imageModifier = Modifier.requiredHeight(150.dp).fillMaxWidth().clip(shape = RoundedCornerShape(8.dp))
            Image(painter = image,modifier = imageModifier,contentScale = ContentScale.Crop, contentDescription = "header")
            Spacer(modifier = Modifier.requiredHeight(16.dp))
            Text(text = recipe.title,style = typography.h6)
            for(ingredient in recipe.ingredients){
                Text(text = "* $ingredient",style = typography.body2)
            }
        }
    }
}

// [EN] We create a RecipeList with LazyColumnFor (same behaviour as RecyclerView)
// [ES] Creamos una lista de recetas con LazyColumnFor (mismo comportamiento que RecyclerView)
@Composable
fun RecipeRowListDemo(recipeList:List<Recipe>){
    LazyRow {
        items(recipeList) { recipe ->
            RecipeCard(recipe)
        }
    }
}

// [EN] Rendering a preview with the first item of the list
// [ES] Mostramos un preview de uno de los items que creamos
@Preview(showBackground = true)
@Composable
private fun RecipePreview(){
    RecipeCard(recipeList[0])
}