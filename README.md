# Speed Json Messages

## Cards:

### Normal
2-10, j, q, k , a

### Extra
b = back of card

## Client:

### Connect
```
{
	"type": "connect",
	"username": "username"
}
```

### Draw:
```
{
	"type": "draw"
}
```

### Move
```
{
	"type": "move",
	"card": 3,
	"to": 0
}
```

For "card:"

index of card in hand


For "to:"

0 = left pile<br/>
1 = right pile


## Server:

### Card
```
{
	"type": "card",
	"card": "3"
}
```

### Chat
```
{
	"type": "chat",
	"message": "message"
}
```

### Game
```
{
	"type": "game",
	"message": "Congratulations, you won!"
}
```

### Invalid
```
{
	"type": "invalid",
	"message": "message"
}
```

### MiddleCards, OpponentCards, PlayerCards
```
{
	"type": "playerCards",
	"cards": [
		{"card": "b"},
		{"card": "3"},
		{"card": "q"},
		{"card": "b"}
	]
}
```

### Start
```
{
	"type": "start",
	"player": "name"
}
```