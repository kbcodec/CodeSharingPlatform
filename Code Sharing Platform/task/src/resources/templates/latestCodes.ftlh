<!DOCTYPE html>
<html layout:decorate="layouts/defaultLayout" xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
</head>
<body>
<#list codes as code>
    <span id="load_date">${code.lastUpdate}</span>
    <pre id="code_snippet">${code.content}</pre>
</#list>
</body>
</html>