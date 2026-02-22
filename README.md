📌 Project Overview
This repository contains multiple Java-based projects demonstrating networking, multithreading, file handling, REST API integration, and a basic AI-based recommendation system.
The goal of this project is to practice core Java concepts and build real-world application components.



1️⃣ ChatServer.java
- Creates a `ServerSocket` on port 5000
- Accepts multiple client connections simultaneously
- Uses a separate thread (`ClientHandler`) for each connected client
- Maintains a list of active clients using `Vector`
- Broadcasts messages to all connected clients
- Demonstrates server-side socket programming and multithreading

2️⃣ ChatClient.java
- Establishes a socket connection to the chat server (localhost:5000)
- Sends user input messages to the server
- Receives incoming messages using a separate receiver thread
- Demonstrates client-side socket programming and multithreading

3️⃣ FileHandlingUtility.java
- Implements file operations using Java File I/O
- Supports writing, reading, and appending data to a text file
- Uses try-with-resources for safe file handling
- Menu-driven console interface for user interaction
- Demonstrates exception handling and stream management
-
4️⃣ RecommendationSystem.java
- Implements a basic collaborative filtering recommendation algorithm
- Loads user-item rating data from `ratings.csv`
- Compares target user preferences with other users
- Recommends top 3 unrated items based on aggregated scores
- Uses Java Collections Framework (HashMap) for data storage
- Utilizes Java Streams API for sorting and ranking recommendations
- Demonstrates basic AI logic and data processing in Java

5️⃣ RestApiClient.java
- Implements REST API integration using Java 11 HttpClient
- Sends HTTP GET request to Open-Meteo public weather API
- Receives and processes JSON response data
- Parses JSON using org.json library
- Extracts structured weather information (temperature, wind speed, weather code)
- Demonstrates API consumption and backend data handling

6️⃣ ratings.csv
- Sample dataset containing user-item-rating records
- Format: User, Item, Rating
- Used as input data for the collaborative filtering recommendation system
- Enables generation of personalized item suggestions
 


🛠 Technologies Used
- Java
- Java Sockets
- Multithreading
- File I/O
- REST API Integration
- Basic Recommendation Algorithm



🎯 Key Learning Outcomes

- Implemented multithreaded server architecture
- Built client-server communication system
- Practiced file handling operations
- Integrated REST API for real-time data
- Developed basic AI-based recommendation logic

            

