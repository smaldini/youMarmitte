<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title><g:message code="marmitte.title"/> ${params.username ?: message(code: 'marmitte.title.all')}</title>

  <meta name="layout" content="main"/>
</head>

<body>

<g:form name="newRecipe" controller="recipe" action="save">
  <g:hasErrors bean="${newRecipe}">
    <div class="errors"><g:renderErrors bean="${newRecipe}"/></div>
  </g:hasErrors>
  <div><label for="name">Name</label> <g:textField name="name" value="${newRecipe?.name}"/></div>

  <div><label for="description">Description</label> <g:textArea name="description" value="${newRecipe?.description}"cols="100" rows="100"/></div>

  <div><label for="difficulty">Difficulty</label> <g:select name="difficulty" value="${newRecipe?.difficulty}" from="${[0,1,2,3,4,5]}"
                                                            optionValue="${{d->d*"C"}}"/></div>

  <g:each in="${[0,1,2,3,4,5]}" var="idx">
    <div><label for="ingredient${idx}">Ingredient ${idx}</label> <g:textField name="ingredient.key"/>
      <label for="ingredient${idx}">Quantity</label> <g:textField name="ingredient.value"/></div>
  </g:each>
  <g:submitButton name="recipe" value="${g.message(code:'marmitte.submit')}"/>
</g:form>

</body>
</html>