package Principal;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else if (playerName.equals("player2"))
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return getEqualScore(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
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
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private String getStandardScore() {
        return getScoreDescription(m_score1) + "-" + getScoreDescription(m_score2);
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
}
