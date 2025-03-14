package com.sportsdata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScoreboardTest {

    @Test
    public void testInvalidStartMatch() {
        Scoreboard scoreboard = new Scoreboard();

        // Already existing match
        scoreboard.startMatch("Mexico", "Canada");
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("Mexico", "Canada"));

        // Invalid teams provided
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch(null, "Canada"));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("Mexico", null));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("", "Canada"));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("Mexico", ""));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("Mexico", "Mexico"));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("Mexico", "a".repeat(Match.MAX_TEAM_NAME_LENGTH+1)));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("a".repeat(Match.MAX_TEAM_NAME_LENGTH+1), "Canada"));
    }

    @Test
    public void testStartMatch() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Mexico", "Canada");
        List<Match> matches = scoreboard.getSummary();
        assertEquals(1, matches.size());
        assertEquals("Mexico", matches.get(0).getHomeTeam());
        assertEquals("Canada", matches.get(0).getAwayTeam());
    }

    @Test
    public void testInvalidUpdateScore() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Mexico", "Canada");

        // Match not found
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("Germany", "France", 2, 2));

        // Invalid teams provided
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore(null, "Canada", 0, 0));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("Mexico", null, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("", "Canada", 0, 0));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("Mexico", "", 0, 0));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("Mexico", "Mexico", 0, 0));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("Mexico", "a".repeat(Match.MAX_TEAM_NAME_LENGTH+1), 0, 0));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("a".repeat(Match.MAX_TEAM_NAME_LENGTH+1), "Canada", 0, 0));

        // Invalid score provided
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("Mexico", "Canada", -1, 0));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("Mexico", "Canada", 0, -1));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("Mexico", "Canada", 0, Match.MAX_TEAM_SCORE+1));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("Mexico", "Canada", Match.MAX_TEAM_SCORE+1, 0));
    }

    @Test
    public void testUpdateScore() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 0, 5);
        Match match = scoreboard.getSummary().get(0);
        assertEquals(0, match.getHomeScore());
        assertEquals(5, match.getAwayScore());
    }
}
