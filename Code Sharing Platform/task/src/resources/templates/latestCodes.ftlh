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
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Source Code Pro', monospace;
        }

        .content {
            background-color: #f3f1e8;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            background-color: #e2dabf;
            width: 100vw;
            height: 7rem;
            display: flex;
            justify-content: center;
            align-items: center;
            color: rgb(85, 85, 85);
        }

        #code_snippet {
            border: 2px solid #e2dabf;
            background-color: #f0f0f0;
            height: 15rem;
            width: 40rem;
            resize: none;
            border-radius: 2rem;
            padding: 2rem;
            margin-top: 2rem;
        }

        .code-snippet-date {
            width: 40rem;
            margin: 0.2rem 0 2rem 0;
            display: flex;
            justify-content: flex-end;
            font-size: 0.8rem;
        }

    </style>
</head>
<body>
<div class="content">
    <h1>Latest codes</h1>
    <#list codes as code>
    <div class="code-snippet-block">
        <pre id="code_snippet"><code>${code.getContent()}</code></pre>
    </div>
    <div class="code-snippet-date">
        <span>Created at: </span><span id="load_date">${code.getLastUpdate()}</span>
    </div>
    </#list>
</div>
</body>
</html>