package youmarmitte

import org.apache.commons.lang.builder.HashCodeBuilder

class UserRecipeLike implements Serializable {

	User user
	Recipe recipe

	boolean equals(other) {
		if (!(other instanceof UserRecipeLike)) {
			return false
		}

		other.user?.id == user?.id &&
			other.recipe?.id == recipe?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (recipe) builder.append(recipe.id)
		builder.toHashCode()
	}

	static mapping = {
		id composite: ['recipe', 'user']
		version false
	}

}
