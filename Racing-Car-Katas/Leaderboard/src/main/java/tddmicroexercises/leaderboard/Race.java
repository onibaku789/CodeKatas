package tddmicroexercises.leaderboard;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Race {

  private static final Integer[] POINTS = new Integer[] { 25, 18, 15 };

  private final String name;
  private final List<Driver> results;

  public Race(String name, Driver... drivers) {
    this.name = name;
    this.results = Arrays.asList(drivers);
  }

  public int position(Driver driver) {
    return this.results.indexOf(driver);
  }

  public int getPoints(Driver driver) {
    return Race.POINTS[position(driver)];
  }

  public List<Driver> getResults() {
    return results;
  }

  public String getDriverName(Driver driver) {
    Optional<Driver> foundDriver = results.stream().filter(driver::equals).findFirst();
    if (foundDriver.isPresent()) {
      return foundDriver.get().getName();
    }
    throw new RuntimeException();
  }

  @Override
  public String toString() {
    return name;
  }
}
