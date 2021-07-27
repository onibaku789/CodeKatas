public class TennisGame1 implements TennisGame {

  private final Player firstPlayer;
  private final Player secondPlayer;

  public TennisGame1(String firstPlayerName, String secondPlayerName) {
    firstPlayer = new Player(firstPlayerName);
    secondPlayer = new Player(secondPlayerName);
  }

  public void wonPoint(String playerName) {
    if (firstPlayer.isThisPlayer(playerName)) {
      firstPlayer.score();
    } else {
      secondPlayer.score();
    }
  }

  public String getScore() {
    if (isDraw()) {
      return calculateScoreForDraw();
    } else if (doAnyPlayerWon()) {
      return calculateScoreForWinner();
    } else {
      return calculateCurrentScore();
    }
  }

  private boolean doAnyPlayerWon() {
    return firstPlayer.getScore() >= 4 || secondPlayer.getScore() >= 4;
  }

  private boolean isDraw() {
    return firstPlayer.getScore() == secondPlayer.getScore();
  }

  private String calculateCurrentScore() {
    return getScore(firstPlayer.getScore()) + "-" + getScore(secondPlayer.getScore());
  }

  private String getScore(int tempScore) {
    switch (tempScore) {
      case 0:
        return "Love";
      case 1:
        return "Fifteen";
      case 2:
        return "Thirty";
      case 3:
        return "Forty";
      default:
        throw new RuntimeException();
    }
  }

  private String calculateScoreForWinner() {
    int difference = firstPlayer.getScore() - secondPlayer.getScore();
    if (difference > 0) {
      return getString(difference, firstPlayer.getPlayerName());
    } else {
      return getString(difference * -1, secondPlayer.getPlayerName());
    }
  }

  private String getString(int difference, String winnerName) {
    if (difference == 1) {
      return "Advantage " + winnerName;
    } else {
      return "Win for " + winnerName;
    }
  }

  private String calculateScoreForDraw() {
    String result;
    switch (firstPlayer.getScore()) {
      case 0:
        result = "Love-All";
        break;
      case 1:
        result = "Fifteen-All";
        break;
      case 2:
        result = "Thirty-All";
        break;
      default:
        result = "Deuce";
        break;
    }
    return result;
  }
}
