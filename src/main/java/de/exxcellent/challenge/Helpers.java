package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import de.exxcellent.challenge.Enums.InputType;
import de.exxcellent.challenge.entities.FootballGame;
import de.exxcellent.challenge.entities.Weather;

final class Helpers {

  private Helpers() { }

  public static <E> List<E> createModelFromCSV(
    final String fileName, final InputType inputType) {
    List<E> entities = new ArrayList<>();
    Path pathToFile = Paths.get(fileName);

    try (BufferedReader br = Files.newBufferedReader(pathToFile,
            StandardCharsets.US_ASCII)) {

      String line = br.readLine();
      line = br.readLine();

      while (line != null) {
        String[] attributes = line.split(",");
        E entity = null;

        switch (inputType) {
          case weather: entity = (E) createWeather(attributes); break;
          case football: entity = (E) createFootballGame(attributes); break;
          default: entity = null;
        }

        entities.add(entity);

        line = br.readLine();
      }

    } catch (IOException ioe) {
        ioe.printStackTrace();
    }

    return entities;
  }



  private static Weather createWeather(final String[] metadata) {
    String day = metadata[0];
    int maxTemp = Integer.parseInt(metadata[1]);
    int minTemp = Integer.parseInt(metadata[2]);

    return new Weather(day, maxTemp, minTemp);
  }

  private static FootballGame createFootballGame(final String[] metadata) {
    final int five = 5;
    final int six = 6;

    String day = metadata[0];
    int goals = Integer.parseInt(metadata[five]);
    int goalsAllowed = Integer.parseInt(metadata[six]);

    return new FootballGame(day, goals, goalsAllowed);
  }

}
