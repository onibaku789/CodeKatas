package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {

  private final static double LOW_PRESSURE_THRESHOLD = 17;
  private final static double HIGH_PRESSURE_THRESHOLD = 21;

  private final Sensor sensor;

  private boolean alarmOn;

  public Alarm(Sensor sensor) {
    this.sensor = sensor;
  }

  public void check() {
    double psiPressureValue = sensor.popNextPressurePsiValue();
    if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue) {
      alarmOn = true;
    }
  }

  public boolean isAlarmOn() {
    return alarmOn;
  }
}
