package com.hellofresh.task1
import org.junit.Assert
import org.junit.Test

class MenuModelTest {
    private val recipeWithSelection: List<RecipeWithSelection> = listOf(
        RecipeWithSelection("001", "test 0", listOf(RecipeTag.HOT, RecipeTag.QUICK), true),
        RecipeWithSelection("002", "test 1", listOf(RecipeTag.QUICK), false),
        RecipeWithSelection("003", "test 2", listOf(RecipeTag.LOW_CALORIES, RecipeTag.QUICK), false),
        RecipeWithSelection("004", "test 3", listOf(RecipeTag.HOT, RecipeTag.LOW_CALORIES), false),
        RecipeWithSelection("005", "test 4", listOf(RecipeTag.LOW_CALORIES), false),
        RecipeWithSelection("006", "test 5", listOf(RecipeTag.QUICK), false),
        RecipeWithSelection("007", "test 6", listOf(RecipeTag.LOW_CALORIES), false)
    )

    private val subscriptionModel = SubscriptionModel("001", "SUNDAY", true)
    private val sampleMenu: MenuModel = MenuModel(recipeWithSelection, subscriptionModel)

    @Test
    fun check_SelectRecipe() {
        sampleMenu.selectRecipe(recipeWithSelection[0])
    }
    @Test
    fun check_SelectMultipleRecipe() {
        sampleMenu.selectRecipe(recipeWithSelection.subList(1, 2))
    }

    @Test
    fun check_UnselectRecipe() {
        sampleMenu.unSelectRecipe(recipeWithSelection[0])
    }

    @Test
    fun check_UnselectMultipleRecipe() {
        sampleMenu.unSelectRecipe(recipeWithSelection.subList(1, 1))
    }

    @Test
    fun check_GetSelectedRecipeCount() {
        val expected = 1
        Assert.assertEquals(expected, sampleMenu.getSelectedRecipeCount())
    }

    @Test
    fun check_GetSelectedRecipes() {
        val expected = 1
        val recipes = sampleMenu.getSelectedRecipes()
        Assert.assertEquals(expected, recipes.size)
    }

    @Test
    fun check_GetSelectedRecipesByTag() {
        val expected = 2
        val recipes = sampleMenu.getSelectedRecipes(RecipeTag.HOT)
        Assert.assertEquals(expected, recipes.size)

    }
}