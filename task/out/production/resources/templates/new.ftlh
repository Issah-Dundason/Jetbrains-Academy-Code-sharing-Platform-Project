<html>
    <head>
        <title>Create</title>
        <link rel="stylesheet" href="/css/main.css">
    </head>
<body>
    <div id="container">
        <div id="heading">
            <p>New <div id="menu-buttons"><span class="maximize"></span><span class="minimize"></span><span class="close"></span></div></p>
        </div>
        <div id="content">
            <code><textarea id="code_snippet" placeholder="Paste your code here"></textarea></code>
            <div class="input">
                <p>time:</p>
                <input id="time_restriction" type="text" value="0"/>
            </div>
            <div class="input">
                <p>views permitted:</p>
                <input id="views_restriction" type="text" value="0"/>
            </div>
        </div>
        <button id="send_snippet" type="submit" onclick="send()">
            Submit</button>
    </div>
    <script src="/js/main.js"></script>
</body>
</html>