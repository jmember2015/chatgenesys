<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <title>Simple chat example</title>
    <link href="assets/css/bootstrap.css?v=1.01" rel="stylesheet"/>

</head>
<body style="font-family:Verdana">
<div class="container">
    <div class="row " style="padding-top:40px;">
        <h3 class="text-center">Simple chat example</h3>
        <br/><br/>

        <div class="col-sm-4 col-sm-offset-4 text-center" id="username-page">

            <form id="usernameForm" name="usernameForm">
                <div class="form-group">
                    <input type="text" id="name" placeholder="Your nickname" autocomplete="off" class="form-control"/>
                </div>
                <div class="input-group">
                    <span class="input-group-btn">
                    <button class="btn btn-primary btn-md" type="submit">JOIN</button>
                    </span>
                </div>
            </form>

        </div>
    </div>

    <div class="row " style="padding-top:40px;">
        <div class="col-md-12 hidden" id="chat-page">
            <div class="panel panel-info">
                <div class="panel-heading">
                    RECENT CHAT HISTORY
                </div>
                <div class="media-body connecting">
                    Please wait, while connecting...
                </div>
                <div class="panel-body">
                    <ul class="media-list" id="messageArea"></ul>
                </div>
                <div class="panel-footer">
                    <form id="messageForm" name="messageForm" nameForm="messageForm">
                        <div class="input-group">
                            <input type="text" id="message" class="form-control" autocomplete="off"
                                   placeholder="Enter Message"/>
                            <span class="input-group-btn">
                                        <button class="btn btn-info" type="submit">SEND</button>
                                    </span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/sockjs.min.js?v=1.01"></script>
<script src="assets/js/stomp.min.js?v=1.01"></script>
<script src="assets/js/chat.js?v=1.01"></script>
</body>
</html>
