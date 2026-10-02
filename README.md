# REST API Client

## Task 2 — Java Internship Project

A Java-based REST API client that connects to the **Open-Meteo Weather API**, sends an HTTP request using latitude and longitude, receives weather data in JSON format, and displays the information in a structured form.

## Features

- Accepts latitude and longitude from the user
- Sends an HTTP GET request to a public REST API
- Receives real-time weather data
- Parses JSON response using Gson
- Displays temperature and wind speed
- Displays weather code and weather condition
- Handles API errors and exceptions

## Technologies Used

- Java
- Java HTTP Client
- REST API
- JSON
- Gson
- Open-Meteo API

## Project Structure

```text
REST-API-Client/
├── src/
│   └── WeatherAPI.java
├── lib/
│   └── gson-2.14.0.jar
├── .vscode/
│   └── settings.json
├── screenshots/
│   └── image.png
└── README.md
```

## API Used

This project uses the **Open-Meteo Weather API**.

The API provides weather information without requiring an API key.

The program requests the following information:

- Temperature
- Wind speed
- Weather code
- Current time

## How the Program Works

### 1. Enter Location

The user enters:

```text
Latitude
Longitude
```

### 2. Create API Request

The program creates an HTTP GET request using the entered coordinates.

### 3. Send Request

Java's `HttpClient` sends the request to the Open-Meteo API.

### 4. Receive JSON Response

The API returns weather information in JSON format.

### 5. Parse JSON

The Gson library is used to extract the required values from the JSON response.

### 6. Display Weather Information

The program displays the weather information in a structured format.

## How to Run

### Step 1: Open the project

Open the `REST-API-Client` folder in VS Code.

### Step 2: Make sure Gson is available

The Gson library is stored inside:

```text
lib/gson-2.14.0.jar
```

The project references the library through:

```text
.vscode/settings.json
```

### Step 3: Run the program

Run `WeatherAPI.java` from VS Code.

The program will ask for latitude and longitude.

### Sample Input

```text
Enter latitude: 14.4426
Enter longitude: 79.9865
```

## Sample Output

```text
===== WEATHER INFORMATION =====
Latitude     : 14.4426
Longitude    : 79.9865
Time         : 2026-10-02T08:00
Temperature  : 34.9 °C
Wind Speed   : 15.0 km/h
Weather Code : 2
Condition    : Partly Cloudy
```

## Error Handling

The program checks the HTTP response status.

If the API request fails, the program displays the HTTP status code.

It also uses exception handling to handle errors during the API request or JSON processing.

## Learning Outcomes

Through this project, I practiced:

- Working with REST APIs
- Sending HTTP GET requests
- Using Java `HttpClient`
- Processing JSON data
- Using the Gson library
- Handling API responses
- Exception handling
- Displaying structured data

## Internship Task

**Task:** REST API Client

**Objective:** Build a Java application that consumes a public REST API and displays structured data.

**Status:** Completed
