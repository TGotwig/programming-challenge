package de.exxcellent.challenge;

import java.util.List;

import de.exxcellent.challenge.Enums.InputType;
import de.exxcellent.challenge.entities.FootballGame;
import de.exxcellent.challenge.entities.Weather;

/**
 * The entry class for your solution. This class is only aimed as starting point
 * and not intended as baseline for your software design. Read: create your own
 * classes and packages as appropriate.
 *
 * @author Benjamin Schmid benjamin.schmid@exxcellent.de
 */
public final class App {

  /**
  * Instantiates a new App. Private to prevent instantiation
  */
  private App() { }

  /**
   * This is the main entry method of your program.
   *
   * @param args - The CLI arguments passed.
   */
  public static void main(final String... args) {

    // Your preparation code …

    List<Weather> weathers = Helpers.<Weather>createModelFromCSV(
      "src/main/resources/de/exxcellent/challenge/weather.csv",
      InputType.weather);

    List<FootballGame> football = Helpers.<FootballGame>createModelFromCSV(
      "src/main/resources/de/exxcellent/challenge/football.csv",
      InputType.football);

    // Your day analysis function call …
    String dayWithSmallestTempSpread = Weather.getDayWithLowestSpread(weathers);

    System.out.printf("Day with smallest temperature spread : %s%n",
        dayWithSmallestTempSpread);

    // Your goal analysis function call …
    String teamWithSmallestGoalSpread = FootballGame
      .getDayWithLowestSpread(football);

    System.out.printf("Team with smallest goal spread       : %s%n",
        teamWithSmallestGoalSpread);
  }

}
