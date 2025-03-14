package com.sportsdata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatchTest {

    @Test
    void testInvalidMatchCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Match(null, "France"));

        assertThrows(IllegalArgumentException.class, () -> new Match("Germany", null));

        assertThrows(IllegalArgumentException.class, () -> new Match("", "France"));

        assertThrows(IllegalArgumentException.class, () -> new Match("Germany", ""));
    }
}
