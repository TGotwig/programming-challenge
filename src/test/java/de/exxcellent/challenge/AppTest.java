package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
    assertEquals(2, tempSpreads.get(0).getDay());
    assertEquals(1, tempSpreads.get(1).getDay());
    assertEquals(MAX, tempSpreads.get(2).getDay());

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

    List<FootballGame> footballGames = FootballGame
      .getFootballGameByGoalDistance(data);
    assertEquals("B", footballGames.get(0).getTeam());
    assertEquals("A", footballGames.get(1).getTeam());
    assertEquals("C", footballGames.get(2).getTeam());

    String day = FootballGame.getFootballGameWithSmallestGoalDistance(data);
      assertEquals("B", day);
  }

}
