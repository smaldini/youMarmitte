package youmarmitte

class MarmitteTagLib {

    static namespace = 'ym'

    def recipeService
    def springSecurityService

    def like = {attrs ->

        assert attrs.recipe

        def (count, currentUser) = recipeService.countLikes(attrs.recipe.id)

        if (currentUser || count > 0) {
            if (currentUser)
                out << "${message(code: 'marmitte.like.you')} "


            if (currentUser && count > 0)
                out << "${message(code: 'marmitte.like.and')} "


            if (count > 0)
                out <<  "${count} ${message(code: 'marmitte.like.others')} "

            out << "${message(code: 'marmitte.like.message')}"

        }


        if (springSecurityService.loggedIn) {
            if (!currentUser) {
                out << remoteLink(controller: 'recipe', id: attrs.recipe.id, action: 'like',update: "recipe-${attrs.recipe.id}",
                        "<span class='button-like'>${message(code: 'marmitte.like.link')}</span>")
            } else {
                out << remoteLink(controller: 'recipe', id: attrs.recipe.id, action: 'unlike', update: "recipe-${attrs.recipe.id}",
                        "<span class='button-like'>${message(code: 'marmitte.unlike.link')}</span>")
            }
        }
    }
}
