package parrot;

public class AfricanParrot implements Parrot {
  private final int numberOfCoconuts;
  private final int loadFactor;

  public AfricanParrot(int numberOfCoconuts) {
    this.numberOfCoconuts = numberOfCoconuts;
    this.loadFactor = 9;
  }

  @Override
  public double getSpeed() {
    return Math.max(0, 12 - loadFactor * numberOfCoconuts);
  }
}
