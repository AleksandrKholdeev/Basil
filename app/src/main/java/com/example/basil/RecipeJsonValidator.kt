package com.example.basil

import android.app.Activity
import android.util.Log
import com.example.basil.model.Direction
import com.example.basil.model.Ingredient
import com.example.basil.model.Nutrition
import com.example.basil.model.Recipe
import org.json.JSONException
import org.json.JSONObject

fun getRecipesFromFilePath(activity: Activity): ArrayList<Recipe> {
    var recipes: ArrayList<Recipe>

    val inputString = activity.assets.open("recipes.json")
        .bufferedReader()
        .use { it.readText() }
    recipes = getValidatedRecipes(inputString)

    return recipes
}

private fun getValidatedRecipes(recipesJSONObject: String): ArrayList<Recipe> {
    var recipes: ArrayList<Recipe> = ArrayList()
    var recipe: Recipe
    var temp: JSONObject
    val jsonObject = JSONObject(recipesJSONObject)
    Log.d("RecipesFragmentLog", "jsonObject = " + jsonObject)
    val jsonArray = jsonObject.getJSONArray("recipes")
    for (i in 0 until jsonArray.length()) {
        temp = jsonArray.getJSONObject(i)
        val recipeJSONObject = temp.getJSONObject("Recipe")
        recipe = Recipe()
        try {
            recipe.title = recipeJSONObject.getString("title")
            recipe.shortDescription = recipeJSONObject.getString("shortDescription")
            recipe.recipeImagePath = recipeJSONObject.getString("recipeImagePath")
            recipe.nutritionPerServing = getValidatedNutrition(recipeJSONObject)
            recipe.ingredients = getValidatedIngredients(recipeJSONObject)
            recipe.directions = getValidatedDirections(recipeJSONObject)
            recipes.add(recipe)
        } catch (exception: JSONException) {
            Log.d("RecipesFragmentLog", "JSONException = " + exception)
        }
    }

    return recipes
}


private fun getValidatedNutrition(recipeJsonObject: JSONObject): Nutrition {
    val nutritionJSONObject = recipeJsonObject.getJSONObject("nutritionalPerServing")
    val nutrition = Nutrition()
    nutrition.numberOfCalories = nutritionJSONObject.getInt("numberOfCalories")
    nutrition.numberOfProteins = nutritionJSONObject.getInt("numberOfProtein")
    nutrition.numberOfProteins = nutritionJSONObject.getInt("numberOfFat")
    nutrition.isContainsGluten = nutritionJSONObject.getBoolean("isContainsGluten")
    nutrition.isContainsEggs = nutritionJSONObject.getBoolean("isContainsEggs")
    return nutrition
}

private fun getValidatedIngredients(recipeJsonObject: JSONObject): ArrayList<Ingredient> {
    var ingredients: ArrayList<Ingredient> = ArrayList()
    var ingredient: Ingredient
    var ingredientJsonObject: JSONObject
    val ingredientsJsonArray = recipeJsonObject.optJSONArray("ingredients")
    for (i in 0 until ingredientsJsonArray.length()) {
        ingredientJsonObject = ingredientsJsonArray.getJSONObject(i)
        ingredient = Ingredient(
            ingredientName = ingredientJsonObject.getString("ingredientName"),
            ingredientAmount = ingredientJsonObject.getString("ingredientAmount"),
            amountType = ingredientJsonObject.getString("amountType"),
        )
        ingredients.add(ingredient)
    }

    return ingredients
}

private fun getValidatedDirections(recipeJsonObject: JSONObject): ArrayList<Direction> {
    var directions: ArrayList<Direction> = ArrayList()
    var direction: Direction
    var directionJsonObject: JSONObject
    val directionsJsonArray = recipeJsonObject.optJSONArray("directions")
    for (i in 0 until directionsJsonArray.length()) {
        directionJsonObject = directionsJsonArray.getJSONObject(i)
        direction = Direction(
            directionTitle = directionJsonObject.optString("directionTitle", ""),
            directionDescription = directionJsonObject.getString("directionDescription"),
        )
        directions.add(direction)
    }
    return directions
}
