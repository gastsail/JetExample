package com.example.jetexample

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

import com.example.jetexample.ui.typography

val recipeList = listOf(Recipe(R.drawable.header,"Test", listOf("Azucar","Tomate","lasagna")),
        Recipe(R.drawable.header,"Test", listOf("Azucar","Tomate","lasagna")),
        Recipe(R.drawable.header,"Test", listOf("Azucar","Tomate","lasagna")))


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeList(recipeList)
        }
    }
}

@Composable
fun RecipeCard(recipe: Recipe) {
    val image = imageResource(R.drawable.header)
    Column(modifier = Modifier.padding(16.dp)) {
        val imageModifier = Modifier
                .preferredHeight(150.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))

        Image(image,modifier= imageModifier, contentScale = ContentScale.Crop)
        Spacer(Modifier.preferredHeight(16.dp))
        Text(recipe.title, style = typography.h6)
        for(ingredient in recipe.ingredients){
            Text(ingredient,style = typography.body2)
        }
    }
}

@Composable
fun RecipeList(recipeList:List<Recipe>){
    LazyColumnFor(recipeList) { item ->
        RecipeCard(recipe = item)
    }
}

@Preview(showBackground = true)
@Composable
fun RecipePreview(){
    RecipeCard(recipeList[0])
}

data class Recipe(
        @DrawableRes val imageResource: Int,
        val title: String,
        val ingredients: List<String>
)


