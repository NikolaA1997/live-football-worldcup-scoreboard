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

}
