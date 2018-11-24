
<html>

<head>
    <title>Speed</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>

<body>
    <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Speed</a>
        <div class="mx-auto">
            <div id="serverMessage" class="h3 text-center">Waiting for other player...</div>
        </div>
    </nav>
    <div class="wrapper"></div>
    <div class="container-fluid" style="max-height: 990px;">
        <section class="row mt-2" id="enemyHand">
            <div class="col" id="opponentDeck">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" id="draw0">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -1px; left: -1px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -2px; left: -2px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -3px; left: -3px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -4px; left: -4px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -5px; left: -5px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -6px; left: -6px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -7px; left: -7px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -8px; left: -8px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -9px; left: -9px;">
            </div>

            <div class="col">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid" id="opponentCard0">
            </div>
            <div class="col">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid" id="opponentCard1">
            </div>
            <div class="col">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid" id="opponentCard2">
            </div>
            <div class="col">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid" id="opponentCard3">
            </div>
            <div class="col">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid" id="opponentCard4">
            </div>
        </section>
        <h3 class="text-center" id="enemyName">Opponent's Hand</h3>
        <h3 class="text-center" id="playerName">Your Hand</h3>


        <section class="row mx-auto" id="mainCards">
            <div class="col">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" id="draw0">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -1px; left: -1px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -2px; left: -2px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -3px; left: -3px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -4px; left: -4px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -5px; left: -5px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -6px; left: -6px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -7px; left: -7px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -8px; left: -8px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -9px; left: -9px;">
            </div>
            <div class="col">
                <img src="img/red_back.png" ondragover="allowDrop(event)" ondrop="drop(event)" ondragstart="preventDrag(event)"
                    class="img-fluid" id="play0">
            </div>
            <div class="col">
                <img src="img/red_back.png" ondragover="allowDrop(event)" ondrop="drop(event)" ondragstart="preventDrag(event)"
                    class="img-fluid" id="play1">
            </div>
            <div class="col" style="margin-left: 30px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" id="draw1">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -1px; left: 1px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -2px; left: 2px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -3px; left: 3px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -4px; left: 4px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -5px; left: 5px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -6px; left: 6px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -7px; left: 7px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -8px; left: 8px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -9px; left: 9px;">
            </div>
        </section>

        <section class="row mx-auto" id="playerCards">
            <div class="col">
                <img src="img/red_back.png" class="img-fluid" id="playerCard0" draggable="true" ondragstart="drag(event)">
            </div>
            <div class="col">
                <img src="img/red_back.png" class="img-fluid" id="playerCard1" draggable="true" ondragstart="drag(event)">
            </div>
            <div class="col">
                <img src="img/red_back.png" class="img-fluid" id="playerCard2" draggable="true" ondragstart="drag(event)">
            </div>
            <div class="col">
                <img src="img/red_back.png" class="img-fluid" id="playerCard3" draggable="true" ondragstart="drag(event)">
            </div>
            <div class="col">
                <img src="img/red_back.png" class="img-fluid" id="playerCard4" draggable="true" ondragstart="drag(event)">
            </div>
            <div class="col" onclick="draw()">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" id="draw">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -1px; left: 1px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -2px; left: 2px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -3px; left: 3px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -4px; left: 4px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -5px; left: 5px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -6px; left: 6px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -7px; left: 7px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -8px; left: 8px;">
                <img src="img/red_back.png" ondragstart="preventDrag(event)" class="img-fluid draw-deck" style="top: -9px; left: 9px;">
            </div>
        </section>

    </div>
    <div id="messageTest">
        <h4>Message Simulator</h4>
        <button class="btn btn-primary" id="startTest">Start</button>
        <button class="btn btn-primary" id="invalidTest">Invalid Move</button>
        <button class="btn btn-primary" id="stuckTest">Stuck</button>
        <button class="btn btn-primary" id="opponentTest">Opponent Cards</button>
        <button class="btn btn-primary" id="middleTest">Middle Cards</button>
        <button class="btn btn-primary" id="playerTest">Player Cards</button>
        <button class="btn btn-primary" id="gameTest">Game Over</button>
    </div>

    <!-- User Modal -->
    <div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Welcome to Speed!</h5>
                    </button>
                </div>
                <div class="modal-body">
                    Please enter your name to start the game. <span id="userError" class="text-danger"></span>
                    <div class="input-group mb-3">
                        <input type="text" id="userName" class="form-control" placeholder="Player Name" aria-label="Recipient's username"
                            aria-describedby="button-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" onclick="validateName()" type="button" id="saveUser">Submit</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Game Over Modal -->
    <div class="modal fade" id="gameOverModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <span class="h1">Game Over</span>
                </div>
                <div class="modal-body">
                    <span class="h2" id="gameOverMessage"></span>
                </div>
            </div>
        </div>
    </div>



    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js" integrity="sha384-pjaaA8dDz/5BgdFUPX6M/9SUZv4d12SUPF0axWc+VRZkx5xU3daN+lYb49+Ax+Tl"
        crossorigin="anonymous"></script>
    <script type="text/javascript">
        $(window).on('load', function () {
            $(".wrapper").hide();
            $('#userModal').modal('show');
        });
    </script>

    <script type="text/javascript">
        var enemyUser = "";
        var user = "";
        var hasMoved = false;
        var imgSource = "";
        var imgName = "";
        /////////////////////////////////////
        //////// Message Testing////////////

        //test server messages
        function testMessages(event) {
            console.log(event);
            var message = JSON.parse(event);
            console.log(message.type);
            switch (message.type) {
            case "start":
                enemyUser = message.player;
                updateMessage("Connected to " + enemyUser);
                $("#enemyName").text(enemyUser + "'s hand");
                break;
            case "playerCards":
                showPlayerCards(message.cards);
                break;
            case "middleCards":
                showMiddleCards(message.cards);
                break;
            case "opponentCards":
                showOpponentCards(message.cards);
                break;
            case "game":
                updateMessage(message.message);
                gameOver(message.message);
                break;
            case "invalid":
                updateMessage(message.message);
                break;
            case "stuck":
            	updateMessage("Both players are stuck! Cards will be flipped automatically.");
            	isStuck = true;
            	break;
            default: console.log("No statements were hit!");
        }
            console.log(enemyUser);
        }

        $("#startTest").click(function () {
            var obj = '{"type":"start", "player": "Player Name"}';
            testMessages(obj);
        });
        $("#playerTest").click(function () {
            var obj = '{"type": "playerCards",	"cards": [{"card": ' + randomInt() + '},{"card": ' + randomInt() + '},{"card": ' + randomInt() + '},{"card": ' + randomInt() + '}, {"card": ' + randomInt() + '}]}';
            testMessages(obj);
        });

        $("#middleTest").click(function () {
            var obj = '{"type": "middleCards",	"cards": [{"card": "b"},{"card": ' + randomInt() + '},{"card": ' + randomInt() + '},{"card": "b"}]}';
            testMessages(obj);
        });

        $("#opponentTest").click(function () {
            var obj = '{"type": "opponentCards", "cards": ' + randomCount() + '}';
            testMessages(obj);
        });

        $("#gameTest").click(function () {
            var obj = '{"type": "game", "message": "Congratulations! You won!"}';
            testMessages(obj);
        });

        $("#invalidTest").click(function () {
            var obj = '{"type": "invalid", "message": "That is an invalid move!"}';
            testMessages(obj);
        });
        $("#stuckTest").click(function () {
            var obj = '{"type": "stuck"}';
            testMessages(obj);
        });

        function randomCount() {
            return Math.floor(Math.random() * (5) + 1);
        }

        function randomInt() // min and max included
        {
            return Math.floor(Math.random() * (13) + 1);
        }
        //////END MESSAGE TESTING////////
        /////////////////////////////////

        //update server message with animation
        function updateMessage(msg) {

            $("#serverMessage").fadeIn(1);
            $("#serverMessage").text(msg);
            $("#serverMessage").effect("bounce");
            $("#serverMessage").fadeOut(1000);
        }

        //create websocket
        //var socket = new WebSocket("wss://cs3750-speed.azure-websites.com/speed/game");
  		var socket = new WebSocket("ws://" + window.location.host + "/websocket/game");
		var isStuck = false;
        //receive server message
        socket.onmessage = function (event) {
            console.log(event.data);
            var message = JSON.parse(event.data);
            switch (message.type) {
                case "start":
                    enemyUser = message.player;
                    updateMessage("Connected to " + enemyUser);
                    $("#enemyName").text(enemyUser + "'s hand");
                    break;
                case "playerCards":
                    showPlayerCards(message.cards);
                    break;
                case "middleCards":
                    showMiddleCards(message.cards);
                    break;
                case "opponentCards":
                    showOpponentCards(message.cards);
                    break;
                case "game":
                    updateMessage(message.message);
                    gameOver(message.message);
                    break;
                case "invalid":
                    updateMessage(message.message);
                    revertMove();
                    break;
                case "stuck":
                	updateMessage("Both players are stuck! Cards will be flipped automatically.");
                	isStuck = true;
                case "ack":
                	console.log("ack received");
                	break;
                default: console.log("No statements were hit!");
            }
        }
        
        //revert move if invalid
        function revertMove(){
        	$("#" + imgName).attr("src", imgSource);
        	imgSource = "";
        	imgName = "";
        }

        function getCard(val) {
            var card = val;
            switch (val) {
                case 1:
                    card = "A";
                    break;
                case 11:
                    card = "J";
                    break;
                case 12:
                    card = "Q";
                    break;
                case 13:
                    card = "K";
                    break;
            }
            return card;
        }

        //select random card suit
        function getSuit() {
            var suits = "DSCH";
            return suits.charAt(Math.floor(Math.random() * 4));
        }

        //show the player's cards  		
        function showPlayerCards(cards) {

            for (var i = 0; i < cards.length; i++) {
                if (cards[i].card != 0) {
                    $("#playerCard" + i).attr("src", "img/" + getCard(cards[i].card) + getSuit() + ".png");
                } else { //if no card is held
                    $("#playerCard" + i).attr("src", "");
                }
            }
        }

        //TODO show the middle cards
        function showMiddleCards(cards) {
			if(isStuck){
				isStuck = false;
				updateMessage("The cards have flipped!");
			}
            //left draw pile
            if (cards[0].card == "b") {
                $("#draw0").attr("src", "img/red_back.png");
            } else {
                $("#draw0").attr("src", "");
            }

            //right draw pile
            if (cards[3].card == "b") {
                $("#draw1").attr("src", "img/red_back.png");
            } else {
                $("#draw1").attr("src", "");
            }

            //left play stack
            $("#play0").attr("src", "img/" + getCard(cards[1].card) + getSuit() + ".png");

            //right play stack
            $("#play1").attr("src", "img/" + getCard(cards[2].card) + getSuit() + ".png");

        }

        //show opponent cards				
        function showOpponentCards(cards) {
            for (var i = 0; i < 5; i++) {
                if (i < cards) {
                    $("#opponentCard" + i).attr('src', "img/red_back.png");
                } else {
                    $("#opponentCard" + i).attr('src', "");
                }
            }

        }

        //show game over message
        function gameOver(message) {
            startConfetti();
            $("#gameOverMessage").text(message);
            $("#gameOverModal").modal(
                {
                    show: true,
                    backdrop: false,
                    keyboard: false
                }
            );
            $(".wrapper").show();
            $(".container-fluid").hide();
            $("#enemyName").hide();
        }


        //move the player card to the specified destination
        function move(source, destination) {
        	hasMoved = true;
            var msg = {
                "type": "move",
                "card": source,
                "to": destination,
                "username": user
            }
            console.log("Sending: " + JSON.stringify(msg));
            socket.send(JSON.stringify(msg));
        }

        //draw a card
        function draw() {
            var msg = {
                "type": "draw"
            }
            socket.send(JSON.stringify(msg));
        }

        //connect to server
        function connectToServer() {

            user = $("#userName").val();
            var msg = 
            	{
                "type": "connect",
                "username": user
            	}
            socket.send(JSON.stringify(msg));


        }

        //close modal on enter
        $('#userModal').keypress(function (e) {
            if (e.keyCode == 13) {
                validateName();
            }
        });

        $('#userModal').modal({
            backdrop: 'static',
            keyboard: false
        });

        //check if name was entered
        function validateName() {
            if ($("#userName").val() != "") {
                connectToServer();
                $('#userModal').modal('hide');
            } else {
                $("#userError").text("Please enter your name.");
            }
        }
        
        function allowDrop(event) {
            event.preventDefault();
        }

        function drag(event) {
            event.dataTransfer.setData("index", event.target.id);

        }

        function drop(event) {
            event.preventDefault();
            var data = event.dataTransfer.getData("index");
            var sourceIndex = data.replace("playerCard", "");
            var destinationIndex = event.target.id.replace("play", "");
            move(sourceIndex, destinationIndex);
            imgSource = $("#" + data).attr("src");
            imgName = data;
            $("#" + data).attr("src", "");
        }

        //prevent dragging
        function preventDrag(event) {
            event.preventDefault();
        }

        //confetti
        function startConfetti() {
            for (var i = 0; i < 250; i++) {
                create(i);
            }
        }

        function create(i) {
            var width = Math.random() * 8;
            var height = width * 0.4;
            var colourIdx = Math.ceil(Math.random() * 3);
            var colour = "red";
            switch (colourIdx) {
                case 1:
                    colour = "yellow";
                    break;
                case 2:
                    colour = "blue";
                    break;
                default:
                    colour = "red";
            }
            $('<div class="confetti-' + i + ' ' + colour + '" ></div>').css({
                "width": width + "px",
                "height": height + "px",
                "top": -Math.random() * 20 + "%",
                "left": Math.random() * 100 + "%",
                "opacity": Math.random() + 0.5,
                "transform": "rotate(" + Math.random() * 360 + "deg)"
            }).appendTo('.wrapper');

            dropConfetti(i);
        }

        function dropConfetti(x) {
            $('.confetti-' + x).animate({
                top: "100%",
                left: "+=" + Math.random() * 15 + "%"
            }, Math.random() * 3000 + 3000, function () {
                reset(x);
            });
        }

        function reset(x) {
            $('.confetti-' + x).animate({
                "top": -Math.random() * 20 + "%",
                "left": "-=" + Math.random() * 15 + "%"
            }, 0, function () {
                dropConfetti(x);
            });
        }
    </script>
</body>

</html>
