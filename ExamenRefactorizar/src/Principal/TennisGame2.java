package Principal;

public class TennisGame2 implements TennisGame {
    private int p1point = 0;
    private int p2point = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String player) {
        if (player.equals("player1")) {
            p1point++;
        } else {
            p2point++;
        }
    }

    public String getScore() {
        if (p1point == p2point) {
            return getEqualScore(p1point);
        } else if (p1point >= 4 || p2point >= 4) {
            return getAdvantageOrWinScore();
        } else {
            return getStandardScore();
        }
    }

    private String getEqualScore(int score) {
        switch (score) {
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }

    private String getAdvantageOrWinScore() {
        int scoreDifference = p1point - p2point;
        if (scoreDifference == 1) return "Advantage player1";
        if (scoreDifference == -1) return "Advantage player2";
        if (scoreDifference >= 2) return "Win for player1";
        return "Win for player2";
    }

    private String getStandardScore() {
        return getScoreDescription(p1point) + "-" + getScoreDescription(p2point);
    }

    private String getScoreDescription(int score) {
        switch (score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return "";
        }
    }

    public void setP1Score(int number) {
        p1point = number;
    }

    public void setP2Score(int number) {
        p2point = number;
    }
}
