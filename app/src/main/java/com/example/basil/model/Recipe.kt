package com.example.basil.model

data class Recipe(
    var title: String,
    var shortDescription: String,
    var recipeImagePath: String,
    var nutritionPerServing: Nutrition,
    var ingredients: ArrayList<Ingredient>,
    var directions: ArrayList<Direction>,
) {
    constructor() : this("", "", "", Nutrition(), ArrayList(), ArrayList())
}
