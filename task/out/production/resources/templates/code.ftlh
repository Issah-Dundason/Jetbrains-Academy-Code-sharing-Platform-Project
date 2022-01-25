<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
</head>
<body>
    <div id="container">
        <div id="heading">
            <p>
                ${code.getId()}
                <div id="menu-buttons">
                    <span class="maximize"></span>
                    <span class="minimize"></span>
                    <span class="close"></span>
                </div>
            </p>
        </div>
        <div id="content">
            <span id="load_date">Date and time uploaded: ${code.getDate()}</span>
            <#if code.isRestricted()>
                <#if (code.getViews() > 0 || code.isViewsRestricted())>
                    <span id="views_restriction">${code.getViews()} more views allowed</span>
                </#if>
                <#if (code.getTime() > 0)>
                    <span id="time_restriction">The code will be available for ${code.getTime()} seconds</span>
                </#if>
            </#if>
            <pre id="code_snippet">
            <code>
                ${code.getCode()}
            </code>
        </pre>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</body>
</html>