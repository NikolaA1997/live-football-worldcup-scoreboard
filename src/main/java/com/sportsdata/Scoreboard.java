package com.sportsdata;

import java.util.*;

public class Scoreboard {
    private final Deque<Match> matches;

    public Scoreboard() {
        this.matches = new LinkedList<>();
    }

    public void startMatch(String homeTeam, String awayTeam) {
        for (Match match : matches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                throw new IllegalArgumentException("Match already exists");
            }
        }
        matches.addFirst(new Match(homeTeam, awayTeam));
    }

    public List<Match> getSummary() {
        List<Match> sortedMatches = new ArrayList<>(matches);
        sortedMatches.sort(Comparator.comparingInt(Match::getTotalScore).reversed());
        return sortedMatches;
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        for (Match match : matches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                match.setScore(homeScore, awayScore);
                return;
            }
        }
        throw new IllegalArgumentException("Match not found");
    }
}
