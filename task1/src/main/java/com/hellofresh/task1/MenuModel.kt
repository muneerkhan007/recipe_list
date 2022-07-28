package com.hellofresh.task1

class MenuModel(
    var recipes: List<RecipeWithSelection>,
    var subscription: SubscriptionModel
) {
    fun selectRecipe(selectedRecipe: RecipeWithSelection) {
        for(recipe in recipes) {
            if(recipe.id == selectedRecipe.id) {
                if (checkRestriction()) {
                    recipe.selected = true
                    println(recipe)
                }
            }
        }
    }

    fun selectRecipe(selectedRecipes: List<RecipeWithSelection>) {
        for(selectedRecipe in selectedRecipes) {
            selectRecipe(selectedRecipe)
        }
    }

    fun unSelectRecipe(selectedRecipe: RecipeWithSelection) {
        for(recipe in recipes) {
            if(recipe.id == selectedRecipe.id) {
                recipe.selected = false
                print(recipe)
            }
        }
    }

    fun unSelectRecipe(selectedRecipes: List<RecipeWithSelection>) {
        for(selectedRecipe in selectedRecipes) {
            unSelectRecipe(selectedRecipe)
        }
    }
    fun getSelectedRecipes(tag: RecipeTag): List<RecipeWithSelection> {
        val tagPredicate: (RecipeTag) -> Boolean = {it == tag}
        val recipePredicate: (RecipeWithSelection) -> Boolean = {
            it.tags?.any(tagPredicate) ?: false
        }
        return recipes.filter(recipePredicate)
    }

    fun getSelectedRecipes(): List<RecipeWithSelection> {
        val predicate: (RecipeWithSelection) -> Boolean = {it.selected}
        return recipes.filter(predicate)
    }

    fun getSelectedRecipeCount(): Int {
        val predicate: (RecipeWithSelection) -> Boolean = {it.selected}
        return recipes.count(predicate)
    }

    private fun checkRestriction(): Boolean {
        val selectedCount = getSelectedRecipeCount()
        return selectedCount < 3 || (subscription.isForFamily && selectedCount < 5)
    }
}