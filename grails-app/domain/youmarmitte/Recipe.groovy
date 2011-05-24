package youmarmitte

class Recipe {

    String name
    String description

    static belongsTo = [author:User]

    Date dateCreated

    Map<String,String> ingredients

    int difficulty = 0

    static constraints = {
        name matches: /[a-zA-Z]*/ , unique: true
        description size:0..400
        difficulty range: 0..5
    }
}
