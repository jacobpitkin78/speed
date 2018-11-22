
<html>
<head>
	<title>Speed</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Speed</a>
	<span id="serverMessage" >Waiting for other player...</span> 
</nav>
<div class="container-fluid" style="max-height: 990px;">
	
	<section class="row mt-2" id="enemyHand">
		<div class="col" id="opponentDeck">
			<img src="img/red_back.png" class="img-fluid draw-deck" id="draw0">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -1px; left: -1px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -2px; left: -2px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -3px; left: -3px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -4px; left: -4px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -5px; left: -5px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -6px; left: -6px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -7px; left: -7px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -8px; left: -8px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -9px; left: -9px;">	
		</div>		
		
		<div class="col">
			<img src="img/red_back.png" class="img-fluid" id="enemyCard0">
		</div>
		<div class="col">
			<img src="img/red_back.png" class="img-fluid" id="enemyCard1">
		</div>
		<div class="col">
			<img src="img/red_back.png" class="img-fluid" id="enemyCard2">
		</div>
		<div class="col">
			<img src="img/red_back.png" class="img-fluid" id="enemyCard3">
		</div>		
		<div class="col">
			<img src="img/red_back.png" class="img-fluid" id="enemyCard4">
		</div>			
	</section>
	<h3 class="text-center" id="enemyName">Opponent's Hand</h3>
	
	
	<section class="row mx-auto" id="mainCards" >
		<div class="col">
			<img src="img/red_back.png" class="img-fluid draw-deck" id="draw0">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -1px; left: -1px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -2px; left: -2px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -3px; left: -3px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -4px; left: -4px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -5px; left: -5px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -6px; left: -6px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -7px; left: -7px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -8px; left: -8px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -9px; left: -9px;">	
		</div>
		<div class="col" >
			<img src="img/red_back.png" ondragover="allowDrop(event)" ondrop="drop(event)" class="img-fluid" id="play0">
		</div>
		<div class="col" >
			<img src="img/red_back.png" ondragover="allowDrop(event)" ondrop="drop(event)" class="img-fluid" id="play1">
		</div>
		<div class="col" style="margin-left: 30px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" id="draw1" >
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -1px; left: 1px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -2px; left: 2px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -3px; left: 3px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -4px; left: 4px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -5px; left: 5px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -6px; left: 6px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -7px; left: 7px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -8px; left: 8px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -9px; left: 9px;">	
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
		<div class="col">
			<img src="img/red_back.png" class="img-fluid draw-deck" id="draw">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -1px; left: 1px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -2px; left: 2px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -3px; left: 3px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -4px; left: 4px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -5px; left: 5px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -6px; left: 6px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -7px; left: 7px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -8px; left: 8px;">
			<img src="img/red_back.png" class="img-fluid draw-deck" style="top: -9px; left: 9px;">		
		</div>
	</section>	
	
</div>

<!-- Modal -->
<div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Welcome to Speed!</h5>
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Please enter your name to start the game. <span id="userError"class="text-danger"></span>
        <div class="input-group mb-3">
		  <input type="text" id="userName" class="form-control" placeholder="Player Name" aria-label="Recipient's username" aria-describedby="button-addon2">
		  <div class="input-group-append">
		    <button class="btn btn-outline-secondary" onclick="validateName()" type="button" id="saveUser">Submit</button>
		  </div>
		</div>      
    </div>
  </div>
</div>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script type="text/javascript" src="http://creativecouple.github.com/jquery-timing/jquery-timing.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  	
  	<script type="text/javascript">
	    $(window).on('load',function(){
	        $('#userModal').modal('show');
	    });
	</script>
	
	<script type="text/javascript">
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
	    event.target.appendChild(document.getElementById(data));
	}
	</script>
  	
  	<script type="text/javascript"> 		
  	
  		var enemyUser;
  		var user;
  		var isInvalidMove = false;
  		
  		//create websocket
  		//var socket = new WebSocket("wss://cs3750-speed.azure-websites.com/speed/game");
  		var socket = new WebSocket("ws://" + window.location.host + "/websocket/game");
		
  		//receive server message
  		socket.onmessage = function(event){
  			console.log(event.data);
			var message = JSON.parse(event.data);
			switch(message.type){
				case "start":
					enemyUser = message.username;
					$("#serverMessage").html = "Connected to " + enemyUser;
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
				case "invalid":
					isInvalidMove = true;
					//TODO add server message alerting the user
					break;
			}
		}
  		
  		//select random card suit
  		function getSuit() {
			var suits = "DSCH";		
			return suits.charAt(Math.floor(Math.random() * 4));		  
		}
  		
  		//show the player's cards  		
  		function showPlayerCards(cards){
  			for(var i = 0; i < cards.length; i++){
  				if(cards[i].card != "b"){
  	  				$("#playerCard"+i).attr("src", "img/" + cards[i] + getSuit() + ".png");  					
  				}else{
  					$("#playerCard"+i).attr("src", "");
  				}
  			}
  		}
  		
  		//TODO show the middle cards
  		function showMiddleCards(cards){
  			
  			//left draw pile
  			if(cards[0].card == "b"){
  				$("#draw0").attr("src", "img/red-back.png");
  			}else{ 
  				$("#draw0").attr("src", "");  				
  			}
  			
  			//right draw pile
  			if(cards[3].card == "b"){
  				$("#draw1").attr("src", "img/red-back.png");
  			}else{ 
  				$("#draw1").attr("src", "");  				
  			}
  			
  			//left play stack
  			$("#play0").attr("src", "img/"+ cards[1] + getSuit() +".png");
  			
  			//right play stack
  			$("#play1").attr("src", "img/"+ cards[1] + getSuit() +".png");
  			
  		}
  		
  		//show opponent cards				
  		function showOpponentCards(cards){
  			for(var i = 0; i < cards; i++){
  				$("#enemyCard" + i).html("<img src='img/red_back.png' class='img-fluid' id='enemyCard'" + i + ">'");
  			}
  			
  		}
  		
  		//move the player card to the specified destination
  		function move(source, destination){
  			var msg = {
	  					"type": "move",
	  					"card": source,
	  					"to": destination
  					  }
  			socket.send(msg);
  		}
  		
  		//draw a card
  		function draw(){
  			var msg = {
	  					"type": "draw"	  					
  					  }
  			socket.send(msg);
  		}
  		
  		//connect to server
  		function connectToServer(){
  			
				user = $("#userName").val();
	  			var msg = {
	  					"type": "connect",
	  					"username": user
						  }
				socket.send(msg);  	  			
  			
  			
  		} 		
  		
  		//close modal on enter
  		$('#userModal').keypress(function(e) {
	    	if (e.keyCode == 13) {    		
	    		validateName();
	    	} 
		});
  		
  	//check if name was entered
    	function validateName(){
    		if($("#userName").val() != ""){
    			connectToServer();
        		$('#userModal').modal('hide');        		
    		}else{
    			$("#userError").text("Please enter your name.");
    		}
    	}
		
		
  	</script>
  </html>
