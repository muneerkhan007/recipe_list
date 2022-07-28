package com.hellofresh.task2.home.model

data class RecipeModel(
    var id: String,
    var calories: String,
    var carbos: String,
    var description: String,
    var difficulty: Int,
    var fats: String,
    var headline: String,
    var image: String,
    var name: String,
    var proteins: String,
    var thumb: String,
    var time: String
) {
    constructor(name: String) : this("", "", "", "", 0,
        "","", "", name, "", "", "")
}