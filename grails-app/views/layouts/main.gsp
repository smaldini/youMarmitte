<!DOCTYPE html>
<html>
<head>
  <title><g:layoutTitle default="Grails"/></title>

  <link rel="shortcut icon" href="${r.resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon"/>
  <r:require modules="marmitte"/>
  <r:layoutResources/>
  <g:layoutHead/>
</head>

<body>
<div class="logo">
  <g:link uri="/"><h1>YouMarmitte</h1></g:link>
</div>

<div class="user-menu">
  <sec:ifLoggedIn>
    <sec:username/> | <g:link controller="logout"><g:message code="marmitte.logout.link"/></g:link>
  </sec:ifLoggedIn>
  <sec:ifNotLoggedIn>
    <g:link controller="login"><g:message code="marmitte.login.link"/></g:link>
  </sec:ifNotLoggedIn>
</div>

<div style="clear:both"></div>
<sec:ifLoggedIn>
  <div class="recipe-menu">
    <g:link controller="recipe" action="newRecipe"><g:message code="marmitte.newRecipe.link" /></g:link>
  </div>
</sec:ifLoggedIn>
<div class="content">
  <g:layoutBody/>
</div>
<r:layoutResources/>
</body>
</html>