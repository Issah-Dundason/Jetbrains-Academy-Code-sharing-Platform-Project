<html>
<head>
    <title>Latest</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
</head>
<body>
    <div id="container">
        <div id="heading">
            <p>Latest <div id="menu-buttons"><span class="maximize"></span><span class="minimize"></span><span class="close"></span></div></p>
        </div>
        <div id="content">
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
    </div>
    <script src="https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</body>
</html>