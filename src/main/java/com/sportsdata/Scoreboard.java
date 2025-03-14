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
            if (match.getHomeTeam().equals(awayTeam) && match.getAwayTeam().equals(homeTeam)) {
                throw new IllegalArgumentException("Match with reversed teams already exists");
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

    public void finishMatch(String homeTeam, String awayTeam) {
        boolean removed = matches.removeIf(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam));
        if (!removed) {
            throw new IllegalArgumentException("Match not found");
        }
    }
}
