<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <title>Spring Boot WebSocket Chat Application</title>
    <link rel="stylesheet" href="assets/css/chat.css?v=1.01" />
</head>
<body>
<noscript>
    <h1>JavaScript not available! Apps that need JavaScript!</h1>
</noscript>

<div id="username-page">
    <div class="username-page-container">
        <h1 class="title">Your nickname</h1>
        <form id="usernameForm" name="usernameForm">
            <div class="form-group">
                <input type="text" id="name" placeholder="Username" autocomplete="off" class="form-control" />
            </div>
            <div class="form-group">
                <button type="submit" class="accent username-submit">Start Chatting</button>
            </div>
        </form>
    </div>
</div>

<div id="chat-page" class="hidden">
    <div class="chat-container">
        <div class="chat-header">
            <h2>Genesys chat demo</h2>
        </div>
        <div class="connecting">
            Connecting...
        </div>
        <ul id="messageArea">

        </ul>
        <form id="messageForm" name="messageForm" nameForm="messageForm">
            <div class="form-group">
                <div class="input-group clearfix">
                    <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                    <button type="submit" class="primary">Send</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="assets/js/sockjs.min.js?v=1.01"></script>
<script src="assets/js/stomp.min.js?v=1.01"></script>
<script src="assets/js/chat.js?v=1.01"></script>
</body>
</html>