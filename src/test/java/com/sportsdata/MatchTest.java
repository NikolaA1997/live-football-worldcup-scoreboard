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
    }

    @Test
    void testMatchCreation() {
        assertEquals("Germany", match.getHomeTeam());
        assertEquals("France", match.getAwayTeam());
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }
}
