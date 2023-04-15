<!DOCTYPE html>
<html layout:decorate="layouts/defaultLayout" xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
    <span id="load_date">${date}</span>
    <pre id="code_snippet"><code>${code}</code></pre>
    <#if isTimeRestricion == true>
        <span id="time_restriction">${time}</span>
    </#if>
    <#if isViewsRestriction == true>
        <span id="views_restriction">${view}</span>
    </#if>
</body>
</html>