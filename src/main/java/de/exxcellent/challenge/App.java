package de.exxcellent.challenge;

import java.util.List;

import de.exxcellent.challenge.Enums.InputType;
import de.exxcellent.challenge.entities.FootballGame;
import de.exxcellent.challenge.entities.Weather;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * The entry class for your solution. This class is only aimed as starting point
 * and not intended as baseline for your software design. Read: create your own
 * classes and packages as appropriate.
 *
 * @author Benjamin Schmid benjamin.schmid@exxcellent.de
 */
public final class App {

  /** Path to the weather input-file. */
  @Parameter(names = "-weather",
    description = "Path to the weather input-file.")
  private String inputWeather;

  /** Path to the football input-file. */
  @Parameter(names = "-football",
    description = "Path to the football input-file.")
  private String inputFootball;

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
    App app = new App();
    JCommander.newBuilder()
      .addObject(app)
      .build()
      .parse(args);
    app.run();
  }

  /** Runs after arguments were passed from JCommander. */
  public void run() {
    if (inputWeather != null) {
      List<Weather> weathers = Helpers.<Weather>createModelFromCSV(
        inputWeather, InputType.weather);

      String dayWithSmallestTempSpread = Weather
        .getDayWithSmallestSpread(weathers);

      System.out.printf("Day with smallest temperature spread : %s%n",
        dayWithSmallestTempSpread);
    }

    if (inputFootball != null) {
      List<FootballGame> football = Helpers.<FootballGame>createModelFromCSV(
        inputFootball, InputType.football);

      String teamWithSmallestGoalSpread = FootballGame
        .getFootballGameWithSmallestGoalDistance(football);

      System.out.printf("Team with smallest goal spread       : %s%n",
          teamWithSmallestGoalSpread);
    }
  }

}
