<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
</head>
<body>
    <div>
        <span id="load_date">${code.getDate()}</span>
        <#if (code.getViews() > 0)>
            <span id="time_restriction">${code.getViews()} more views allowed</span>
        </#if>
        <#if (code.getTime() > 0)>
            <span id="views_restriction">The code will be available for ${code.getTime()} seconds</span>
        </#if>
        <pre id="code_snippet">
            <code>
                ${code.getCode()}
            </code>
        </pre>
    </div>
    <script src="https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</body>
</html>