package tddmicroexercises.turnticketdispenser;

import java.util.stream.IntStream;

public class TurnNumberSequence {
  private static int _turnNumber = 0;

  public  int getNextTurnNumber() {
    return _turnNumber++;
  }

  public static int getNextTurnNumber2() {
    return IntStream.generate(() -> _turnNumber++).findFirst().getAsInt();
  }
}
