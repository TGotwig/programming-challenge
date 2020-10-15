package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.entities.Weather;

/**
 * Example JUnit 5 test case.
 *
 * @author Benjamin Schmid benjamin.schmid@exxcellent.de
 */
class AppTest {

  /** A FIVE. */
  public static final int FIVE = 5;
  /** A THREE. */
  public static final int THREE = 3;
  /** A NINE. */
  public static final int NINE = 9;

  @BeforeEach
  void setUp() {
  }

  @Test
  void testSpreadFromWeather() {

    List<Weather> data = Arrays.asList(
      new Weather("A", FIVE, 1),
      new Weather("B", THREE, 1),
      new Weather("C", NINE, 1)
    );

    List<Weather> tempSpreads = Weather.getWeathersByTempSpread(data);
    assertEquals(
      "[{ day='B', maxTemp='3', minTemp='1', tempSpread='2' }, "
      + "{ day='A', maxTemp='5', minTemp='1', tempSpread='4' }, "
      + "{ day='C', maxTemp='9', minTemp='1', tempSpread='8' }]",
      tempSpreads.toString(), "My expectations were not met");

    String day = Weather.getDayWithLowestSpread(data);
    assertEquals("B", day);
  }

  /** Runs football. */
  @Test
  void runFootball() {
    App.main("--football", "football.csv");
  }

}
