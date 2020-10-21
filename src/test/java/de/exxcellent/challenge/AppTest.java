package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.entities.FootballGame;
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
    App.main("-weather",
      "src/main/resources/de/exxcellent/challenge/weather.csv");

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
      tempSpreads.toString());

    String day = Weather.getDayWithSmallestSpread(data);
    assertEquals("B", day);
  }

  /** Runs football. */
  @Test
  void runFootball() {
    App.main("-football",
      "src/main/resources/de/exxcellent/challenge/football.csv");

    List<FootballGame> data = Arrays.asList(
      new FootballGame("A", FIVE, 1),
      new FootballGame("B", THREE, 1),
      new FootballGame("C", 1, NINE)
    );

    List<FootballGame> tempSpreads = FootballGame
      .getFootballGameByGoalDistance(data);
    assertEquals(
      "[{ day='B', goals='3', goalsAllowed='1', goalsDistance='2' }, "
      + "{ day='A', goals='5', goalsAllowed='1', goalsDistance='4' }, "
      + "{ day='C', goals='1', goalsAllowed='9', goalsDistance='8' }]",
      tempSpreads.toString());

    String day = FootballGame.getFootballGameWithSmallestGoalDistance(data);
      assertEquals("B", day);
  }

}
