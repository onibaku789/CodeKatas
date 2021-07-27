public class Player {
  private final String playerName;
  private int score;

  Player(String playerName) {
    this.playerName = playerName;
    this.score = 0;
  }

  public void score() {
    score++;
  }

  public String getPlayerName() {
    return playerName;
  }

  public int getScore() {
    return score;
  }

  public boolean isThisPlayer(String playerName) {
    return this.playerName.equals(playerName);
  }
}
