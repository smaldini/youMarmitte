package youmarmitte

class Recipe {

    String name
    String description

    static belongsTo = [author: User]

    Date dateCreated

    Map<String, String> ingredients

    int difficulty = 0

    static constraints = {
        name blank: false, matches: /\w*/, unique: true
        description size: 0..400
        difficulty range: 0..5
    }


    static namedQueries = {
        lastRecipes {username = null ->
            if (username) {
                author {
                    eq 'username', username, [ignoreCase: true]
                }
            }
            order 'dateCreated', 'desc'
            maxResults 50
        }
    }
}
