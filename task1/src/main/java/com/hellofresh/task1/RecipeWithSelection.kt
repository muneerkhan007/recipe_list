package com.hellofresh.task1

data class RecipeWithSelection(
    override var id: String,
    override var title: String,
    override var tags: List<RecipeTag>? = null,
    var selected: Boolean
): RecipeModel(id, title, tags)