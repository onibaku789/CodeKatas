package tddmicroexercises.turnticketdispenser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TicketDispenserTest {
  @InjectMocks
  private TicketDispenser underTest;
  @Mock
  private TurnNumberSequence turnNumberSequence;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @AfterEach
  public void tearDown() {
    underTest = null;
  }

  @Test
  void foo() {
    given(turnNumberSequence.getNextTurnNumber()).willReturn(0);
    TurnTicket ticket = underTest.getTurnTicket();
    assertEquals(0, ticket.getTurnNumber());
  }

  @Test
  public void getTurnTicket() {
    given(turnNumberSequence.getNextTurnNumber()).willReturn(1);
    TurnTicket ticket = underTest.getTurnTicket();
    assertEquals(1, ticket.getTurnNumber());
  }

  @Test
  public void twoDifferentDispenserShouldNotGiveAlreadyTakenTurnNumber() {
    TurnNumberSequence turnNumberSequence = new TurnNumberSequence();
    TicketDispenser ticketDispenser1 = new TicketDispenser(turnNumberSequence);
    TicketDispenser ticketDispenser2 = new TicketDispenser(turnNumberSequence);
    int firstTurnNumber = ticketDispenser1.getTurnTicket().getTurnNumber();
    int secondTurnNumber = ticketDispenser2.getTurnTicket().getTurnNumber();
    assertNotEquals(firstTurnNumber, secondTurnNumber);
    assertTrue(firstTurnNumber < secondTurnNumber);
    assertEquals(1, secondTurnNumber - firstTurnNumber);
  }
}
