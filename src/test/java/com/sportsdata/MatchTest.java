package com.sportsdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatchTest {

    private Match match;

    @BeforeEach
    void setUp() {
        match = new Match("Germany", "France");
    }

    @Test
    void testInvalidMatchCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Match(null, "France"));
        assertThrows(IllegalArgumentException.class, () -> new Match("Germany", null));
        assertThrows(IllegalArgumentException.class, () -> new Match("", "France"));
        assertThrows(IllegalArgumentException.class, () -> new Match("Germany", ""));
        assertThrows(IllegalArgumentException.class, () -> new Match("a".repeat(Match.MAX_TEAM_NAME_LENGTH+1), "France"));
        assertThrows(IllegalArgumentException.class, () -> new Match("Germany", "a".repeat(Match.MAX_TEAM_NAME_LENGTH+1)));

    }

    @Test
    void testMatchCreation() {
        assertEquals("Germany", match.getHomeTeam());
        assertEquals("France", match.getAwayTeam());
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }

    @Test
    void testInvalidScoreUpdate() {
        assertThrows(IllegalArgumentException.class, () -> match.setScore(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> match.setScore(0, -1));
        assertThrows(IllegalArgumentException.class, () -> match.setScore(0, Match.MAX_TEAM_SCORE+1));
        assertThrows(IllegalArgumentException.class, () -> match.setScore(Match.MAX_TEAM_SCORE+1, 0));
    }

    @Test
    void testUpdateScore() {
        match.setScore(2, 1);
        assertEquals(2, match.getHomeScore());
        assertEquals(1, match.getAwayScore());
    }

    @Test
    void testGetTotalScore() {
        assertEquals(0, match.getTotalScore());
        match.setScore(2, 3);
        assertEquals(5, match.getTotalScore());
    }
}
