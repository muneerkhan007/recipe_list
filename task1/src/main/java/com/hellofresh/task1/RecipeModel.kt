package com.hellofresh.task1

open class RecipeModel(
    open var id: String,
    open var title: String,
    open var tags: List<RecipeTag>? = null
)