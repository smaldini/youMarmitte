package youmarmitte

import grails.plugins.springsecurity.Secured

class RecipeController {

    static allowedMethods = ['save': 'POST']

    def recipeService

    def index = {
        [recipes: Recipe.lastRecipes(params.username).list()]
    }

    @Secured('ROLE_USER')
    def newRecipe = {
        [newRecipe: new Recipe(params)]
    }

    @Secured('ROLE_USER')
    def save = {
        def newRecipe = recipeService.save(params)

        if (newRecipe && !newRecipe.hasErrors()) {
            flash.message = message(code: 'marmitte.success', args: [newRecipe])
            redirect action: 'index'
        } else {
            render view: 'newRecipe', model: [newRecipe: newRecipe]
        }
    }

    def like = {
        if (params.id) {
            recipeService.like(params.long('id'))
        }
        render template:'recipe', model:[recipe:Recipe.get(params.long('id'))]
    }

    def unlike = {
        if (params.id) {
            recipeService.unlike(params.long('id'))
        }
        render template:'recipe', model:[recipe:Recipe.get(params.long('id'))]
    }
}
