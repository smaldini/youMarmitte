<div class="recipe">
  <div class="recipe-content">
    <div class="name">${recipe.name?.encodeAsHTML()}</div>

    <div class="desciption">${recipe.description?.encodeAsHTML()}</div>

    <div>Difficulty : <span class="difficulty">${"C" * recipe.difficulty}</span></div>

    <div>Ingredients :
      <ul><g:each in="${recipe.ingredients}" var="entry">
        <li>${entry.key} : ${entry.value}</li>
      </g:each>
      </ul>
    </div>
  </div>

  <div class="info"><g:formatDate date="${recipe.dateCreated}"
                                  format="dd/MM/yyyy HH:mm"/> by <g:link controller="recipe"
                                                                         params="[username:recipe.author.username]">${recipe.author.username?.encodeAsHTML()}</g:link></div>

  <div class="like">
    <ym:like recipe="${recipe}"/>
  </div>
</div>