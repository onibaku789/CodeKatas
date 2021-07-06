package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AlarmTest {
  @InjectMocks
  private Alarm underTest;

  @Mock
  private Sensor sensor;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @AfterEach
  void tearDown() {
    underTest = null;
  }

  @Test
  void check() {
    //GIVEN
    given(sensor.popNextPressurePsiValue()).willReturn(16d);
    //WHEN
    underTest.check();
    //THEN
    assertTrue(underTest.isAlarmOn());
    then(sensor).should().popNextPressurePsiValue();
  }

  @Test
  void checkWith20() {
    //GIVEN
    given(sensor.popNextPressurePsiValue()).willReturn(20d);
    //WHEN
    underTest.check();
    //THEN
    assertFalse(underTest.isAlarmOn());
    then(sensor).should().popNextPressurePsiValue();
  }

}
