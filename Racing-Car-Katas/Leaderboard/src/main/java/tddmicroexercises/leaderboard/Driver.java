package tddmicroexercises.leaderboard;

import java.util.Objects;

public class Driver implements Comparable<Driver> {

  private final String name;
  private final String country;

  public Driver(String name, String country) {
    this.name = name;
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public String getCountry() {
    return country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Driver))
      return false;
    Driver driver = (Driver) o;
    return Objects.equals(name, driver.name) && Objects.equals(country, driver.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, country);
  }

  @Override
  public int compareTo(Driver o) {
    return 0;
  }
}
