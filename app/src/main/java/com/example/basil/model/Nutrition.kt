package com.example.basil.model

data class Nutrition(
    var numberOfCalories: Int,
    var numberOfProteins: Int,
    var numberOfFat: Int,
    var isContainsGluten: Boolean,
    var isContainsEggs: Boolean
) {
    constructor() : this(0, 0, 0, false, false)
}