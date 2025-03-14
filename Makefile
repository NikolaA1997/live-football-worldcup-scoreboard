# Makefile for Live Football World Cup Scoreboard

# Targets
.PHONY: all clean compile test

all: clean compile test

clean:
	mvn clean

compile:
	mvn compile

test:
	mvn test