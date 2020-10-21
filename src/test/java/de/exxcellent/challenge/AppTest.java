package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
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

  /** The maximum number to use. */
  public static final int MAX = 10;

  @BeforeEach
  void setUp() {
  }

  @Test
  void testSpreadFromWeather() throws IOException {
    App.main("-weather",
      "src/main/resources/de/exxcellent/challenge/weather.csv");

    List<Weather> data = Arrays.asList(
      new Weather(1, 2, 1),
      new Weather(2, 1, 1),
      new Weather(MAX, MAX, 1)
    );

    List<Weather> tempSpreads = Weather.getWeathersByTempSpread(data);
    assertEquals(
      "[{ day='2', maxTemp='1', minTemp='1', tempSpread='0' }, "
      + "{ day='1', maxTemp='2', minTemp='1', tempSpread='1' }, "
      + "{ day='10', maxTemp='10', minTemp='1', tempSpread='9' }]",
      tempSpreads.toString());

    int day = Weather.getDayWithSmallestSpread(data);
    assertEquals(2, day);
  }

  /**
   * Runs football.
   *
   * @throws IOException
   */
  @Test
  void runFootball() throws IOException {
    App.main("-football",
      "src/main/resources/de/exxcellent/challenge/football.csv");

    List<FootballGame> data = Arrays.asList(
      new FootballGame("A", 2, 1),
      new FootballGame("B", 1, 1),
      new FootballGame("C", 1, MAX)
    );

    List<FootballGame> tempSpreads = FootballGame
      .getFootballGameByGoalDistance(data);
    assertEquals(
      "[{ day='B', goals='1', goalsAllowed='1', goalsDistance='0' }, "
      + "{ day='A', goals='2', goalsAllowed='1', goalsDistance='1' }, "
      + "{ day='C', goals='1', goalsAllowed='10', goalsDistance='9' }]",
      tempSpreads.toString());

    String day = FootballGame.getFootballGameWithSmallestGoalDistance(data);
      assertEquals("B", day);
  }

}
