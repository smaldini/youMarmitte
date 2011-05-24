package youmarmitte

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin

class RecipeService {

    static transactional = true
    static final EMPTY_RESULT = [0,0]

    /*
        Inject SpringSecurityService bean from SpringSecCore plugin
     */
    def springSecurityService

    /*
        Usually you will prefer full signatures typing for services
     */
    Recipe save(Map params) {
        def user = springSecurityService.currentUser

        if(!params || !user)
            throw new RuntimeException("Cannot save with user or params $params")


        def newRecipe = new Recipe(params)
        newRecipe.author = user
        newRecipe.ingredients = [:]

        def idx = 0
        for(entry in params.ingredient.key){
            if(entry.trim())
                newRecipe.ingredients[entry] = params.ingredient.value[idx]
            idx++
        }

        newRecipe.save()
        newRecipe
    }

    void like(long recipeId){

        def user = springSecurityService.currentUser
        def recipe = Recipe.get(recipeId)

        if(!recipe || !user)
            throw new RuntimeException("Cannot save with user or params $recipeId")

        new UserRecipeLike(user:user, recipe:recipe).save()
    }

    void unlike(long recipeId){

        def user = springSecurityService.currentUser
        def recipe = Recipe.get(recipeId)

        if(!recipe || !user)
            throw new RuntimeException("Cannot save with user or params $recipeId")

        UserRecipeLike.findByUserAndRecipe(user, recipe, [cache:true])?.delete()
    }


    /*
        Count likes for a specific recipe id
     */
    Collection countLikes(long recipeId){
        def recipe = Recipe.get(recipeId)
        def user = springSecurityService.currentUser

        if(recipe){
            def count = UserRecipeLike.countByRecipe(recipe)
            def isCurrentUser = user ? UserRecipeLike.countByUserAndRecipe(user,recipe, [cache:true]) : false

            count = isCurrentUser ? count-1 : count

            [count, isCurrentUser]
        }else{
            EMPTY_RESULT
        }


    }
}
