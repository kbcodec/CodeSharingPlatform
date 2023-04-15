<!DOCTYPE html>
<html layout:decorate="layouts/defaultLayout" xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<#list codes as code>
    <span id="load_date">${code.getLastUpdate()}</span>
    <pre id="code_snippet"><code>${code.getContent()}</code></pre>
    <#if code.getTimeRestriction() gt 0>
        <span id="time_restriction">${code.getTimeRestriction()}</span>
    </#if>
    <#if code.getViewsRestriction() gt 0>
        <span id="views_restriction">${code.getViewsRestriction()}</span>
    </#if>
</#list>
</body>
</html>