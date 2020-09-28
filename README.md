# Connect4Game
# Used tech stack : Spring Boot ( Framework ) , Java 8
# External Libraries imported : Google Json and Jackson
# Steps to use :

1. Download project.
2. Open Eclipse and Import Downloaded maven project.
3. Run /connect4/src/main/java/com/connect4/connect4/Connect4Application.java. This will initilize bean. Since spring boot has Tomcat as default server, no external server required for testing.
4. Use PostMan to test below API with following details:

Step 1:

# API : http://localhost:8080/playGameConnect4
# Parameters : instruction = START
# Response : 

{
    "status": true,
    "message": "READY",
    "result": "Your user name is user1 .Please use this user name to play the game.",
    "code": 200
}

It will start the game. User has to pass provided userName to play the game. Otherwise user will not able to proceed.

Step 2:

# API : http://localhost:8080/playGameConnect4/user1
# Parameters : columnNumber = 2
# Response : 

{
    "status": true,
    "message": "Move registered successfully",
    "result": [
        "0 1 2 3 4 5 6",
        " | | | | | | ",
        " | | | | | | ",
        " | | | | | | ",
        " | | | | | | ",
        " | | | | | | ",
        " | |Y| | | | ",
        "0 1 2 3 4 5 6"
    ],
    "code": 200
}

Step 3:

# API : http://localhost:8080/playGameConnect4/user1
# Parameters : columnNumber = 1
# Response : 

{
    "status": true,
    "message": "Move registered successfully",
    "result": [
        "0 1 2 3 4 5 6",
        " | | | | | | ",
        " | | | | | | ",
        " | | | | | | ",
        " | | | | | | ",
        " | | | | | | ",
        " |R|Y| | | | ",
        "0 1 2 3 4 5 6"
    ],
    "code": 200
}

Step 4:

# API : http://localhost:8080/playGameConnect4/user1
# Parameters : columnNumber = 2
# Response : 

{
    "status": true,
    "message": "Move registered successfully",
    "result": [
        "0 1 2 3 4 5 6",
        " | | | | | | ",
        " | | | | | | ",
        " | | | | | | ",
        " | | | | | | ",
        " | |Y| | | | ",
        " |R|Y| | | | ",
        "0 1 2 3 4 5 6"
    ],
    "code": 200
}

Step 5:

# API : http://localhost:8080/playGameConnect4/user1
# Parameters : columnNumber = 5
# Response : 

{
    "status": true,
    "message": "Move registered successfully",
    "result": [
        "0 1 2 3 4 5 6",
        " | | | | | | ",
        " | | | | | | ",
        " | | | | | | ",
        " | | | | | | ",
        " | |Y| | | | ",
        " |R|Y| | |R| ",
        "0 1 2 3 4 5 6"
    ],
    "code": 200
}

Step 6:

# API : http://localhost:8080/playGameConnect4/user1
# Parameters : columnNumber = 2
# Response : 

{
    "status": true,
    "message": "Move registered successfully",
    "result": [
        "0 1 2 3 4 5 6",
        " | | | | | | ",
        " | | | | | | ",
        " | | | | | | ",
        " | |Y| | | | ",
        " | |Y| | | | ",
        " |R|Y| | |R| ",
        "0 1 2 3 4 5 6"
    ],
    "code": 200
}

Step 7:

# API : http://localhost:8080/playGameConnect4/user1
# Parameters : columnNumber = 0
# Response : 

{
    "status": true,
    "message": "Move registered successfully",
    "result": [
        "0 1 2 3 4 5 6",
        " | | | | | | ",
        " | | | | | | ",
        " | | | | | | ",
        " | |Y| | | | ",
        " | |Y| | | | ",
        "R|R|Y| | |R| ",
        "0 1 2 3 4 5 6"
    ],
    "code": 200
}

Step 8:

# API : http://localhost:8080/playGameConnect4/user1
# Parameters : columnNumber = 2
# Response : 

{
    "status": true,
    "message": "Move registered successfully",
    "result": [
        "0 1 2 3 4 5 6",
        " | | | | | | ",
        " | | | | | | ",
        " | |Y| | | | ",
        " | |Y| | | | ",
        " | |Y| | | | ",
        "R|R|Y| | |R| ",
        "0 1 2 3 4 5 6"
    ],
    "code": 200
}

Step 9 :

# API : http://localhost:8080/playGameConnect4/user1
# Parameters : columnNumber = 0
# Response : 

{
    "status": true,
    "message": "Yellow wins.",
    "result": [
        "0 1 2 3 4 5 6",
        " | | | | | | ",
        " | | | | | | ",
        " | |Y| | | | ",
        " | |Y| | | | ",
        "R| |Y| | | | ",
        "R|R|Y| | |R| ",
        "0 1 2 3 4 5 6"
    ],
    "code": 200
}




