# Live Football World Cup Scoreboard

A simple library that allows you to manage a Live Football World Cup Scoreboard.
## Features

- Start a new match between two teams (initially 0-0)
- Update the score of an ongoing match
- Finish a match and remove it from the scoreboard
- Get a summary of ongoing matches, ordered by total score and most recently started

## Installation

Add the JitPack repository to your build file:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
Then add the dependency:
```xml
<dependency>
    <groupId>com.github.NikolaA1997</groupId>
    <artifactId>live-football-worldcup-scoreboard</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

```java
// Create a new scoreboard
Scoreboard scoreboard = new Scoreboard();

// Start a match
scoreboard.startMatch("Mexico", "Canada");

// Update score
scoreboard.updateScore("Mexico", "Canada", 0, 5);

// Get a summary of matches (sorted by total score and then by recency)
List<Match> summary = scoreboard.getSummary();

// Finish a match
scoreboard.finishMatch("Mexico", "Canada");
```

## Build and Test

This project uses Maven for building and testing:

```sh
mvn clean package
mvn test
```

## Requirements

- Java 17 or higher
- Maven 3.6 or higher