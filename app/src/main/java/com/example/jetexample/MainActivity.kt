package com.example.jetexample

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

import com.example.jetexample.ui.typography

data class Recipe(
        @DrawableRes val imageResource: Int,
        val title: String,
        val ingredients: List<String>
)

val recipeList = listOf(Recipe(R.drawable.header,"Arrozmate", listOf("Arroz","Tomate","Crema")),
        Recipe(R.drawable.header,"Calabaza", listOf("Queso","Azucar","Agua")),
        Recipe(R.drawable.header,"Torta", listOf("Merengue","Chocolate","Vainilla")),
        Recipe(R.drawable.header,"Torta2", listOf("Merengue2","Chocolate2","Vainilla2")))

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeList(recipeList = recipeList)
        }
    }
}

@Composable
fun RecipeCard(recipe:Recipe){
    val image = imageResource(R.drawable.header)
    Surface(shape = RoundedCornerShape(8.dp),elevation = 8.dp,modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            val imageModifier = Modifier.preferredHeight(150.dp).fillMaxWidth().clip(shape = RoundedCornerShape(8.dp))
            Image(asset = image,modifier = imageModifier,contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            Text(text = recipe.title,style = typography.h6)
            for(ingredient in recipe.ingredients){
                Text(text = ingredient,style = typography.body2)
            }
        }
    }
}

@Composable
fun RecipeList(recipeList:List<Recipe>){
    LazyColumnFor(items = recipeList) { item ->
        RecipeCard(recipe = item)
    }
}

@Preview
@Composable
fun RecipePreview(){
    RecipeCard(recipeList[0])
}







