<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title><g:message code="marmitte.title"/> ${params.username ?: message(code: 'marmitte.title.all')}</title>

  <meta name="layout" content="main"/>
</head>

<body>
<div id="recipes">
  <g:each in="${recipes}" var="recipe">
    <div id="recipe-${recipe.id}">
      <tmpl:recipe recipe="${recipe}"/>
    </div>
  </g:each>
</div>
</body>
</html>