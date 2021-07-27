package parrot;

public class NorwegianBlueParrot implements Parrot {
  private final double voltage;
  private final boolean isNailed;

  public NorwegianBlueParrot( double voltage, boolean isNailed) {
    this.voltage = voltage;
    this.isNailed = isNailed;
  }

  @Override
  public double getSpeed() {
    if (isNailed) {
      return 0;
    }
    return Math.min(24.0, voltage * 12);
  }
}
