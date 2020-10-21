package de.exxcellent.challenge;

import java.io.IOException;
import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

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
  private App() {
  }

  /**
   * This is the main entry method of your program.
   *
   * @param args - The CLI arguments passed.
   * @throws IOException
   */
  public static void main(final String... args) throws IOException {
    App app = new App();
    JCommander.newBuilder()
      .addObject(app)
      .build()
      .parse(args);
    app.run();
  }

  /**
   * Runs after arguments were passed from JCommander.
   *
   * @throws IOException
   */
  public void run() throws IOException {
    if (inputWeather != null) {
      List<Weather> weathers = Helpers.createWeathersFromCsv(inputWeather);

      int dayWithSmallestTempSpread = Weather
        .getDayWithSmallestSpread(weathers);

      System.out.printf("Day with smallest temperature spread : %s%n",
        dayWithSmallestTempSpread);
    }

    if (inputFootball != null) {
      List<FootballGame> footballGames = Helpers
        .createFootballGamesFromCsv(inputFootball);

      String teamWithSmallestGoalSpread = FootballGame
        .getFootballGameWithSmallestGoalDistance(footballGames);

      System.out.printf("Team with smallest goal spread       : %s%n",
          teamWithSmallestGoalSpread);
    }
  }

}
