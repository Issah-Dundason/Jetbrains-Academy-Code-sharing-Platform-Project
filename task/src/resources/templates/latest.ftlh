<html>
<head>
    <title>Latest</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
</head>
<body>
    <div>
        <#list codes as code>
            <div>
                <span id="load_date">${code.getDate()}</span>
                <pre id="code_snippet">
                    <code>
                        ${code.getCode()}
                    </code>
                </pre>
            </div>
        </#list>
    </div>
    <script src="https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</body>
</html>