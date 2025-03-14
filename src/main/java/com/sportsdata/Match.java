package com.sportsdata;

public class Match {

    public static final int MAX_TEAM_SCORE = 100;
    public static final int MAX_TEAM_NAME_LENGTH = 100;

    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;

    public Match(String homeTeam, String awayTeam) {
        if (homeTeam == null || awayTeam == null || homeTeam.isEmpty() || awayTeam.isEmpty()) {
            throw new IllegalArgumentException("Team names cannot be null or empty");
        }
        if (homeTeam.length() > MAX_TEAM_NAME_LENGTH || awayTeam.length() > MAX_TEAM_NAME_LENGTH) {
            throw new IllegalArgumentException("Team name cannot be longer than " + MAX_TEAM_NAME_LENGTH + " characters");
        }
        if (homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException("Teams cannot be the same");
        }
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setScore(int homeScore, int awayScore) {
        if (homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException("Score cannot be negative");
        }
        if (homeScore > MAX_TEAM_SCORE || awayScore > MAX_TEAM_SCORE) {
            throw new IllegalArgumentException("Score cannot be greater than " + MAX_TEAM_SCORE);
        }
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }
}
