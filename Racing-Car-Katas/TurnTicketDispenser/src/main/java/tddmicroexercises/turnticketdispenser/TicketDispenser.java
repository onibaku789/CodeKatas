package tddmicroexercises.turnticketdispenser;

public class TicketDispenser {
  private final TurnNumberSequence turnNumberSequence;

  public TicketDispenser(TurnNumberSequence turnNumberSequence) {
    this.turnNumberSequence = turnNumberSequence;
  }

  public TurnTicket getTurnTicket() {
    int nextTurnNumber = turnNumberSequence.getNextTurnNumber();
    return new TurnTicket(nextTurnNumber);
  }
}
