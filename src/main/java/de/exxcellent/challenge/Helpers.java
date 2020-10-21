package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import de.exxcellent.challenge.Enums.InputType;
import de.exxcellent.challenge.entities.FootballGame;
import de.exxcellent.challenge.entities.Weather;

final class Helpers {

  private Helpers() {
  }

  public static <E> List<E> createModelFromCSV(final String fileName,
  final InputType inputType) {
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
          case football:
            entity = (E) createFootballGame(attributes);
            break;
          default:
            entity = null;
        }

        entities.add(entity);

        line = br.readLine();
      }

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    return entities;
  }

  public static List<Weather> createWeathersFromCsv(final String path)
  throws IOException {
    CsvMapper csvMapper = new CsvMapper();
    csvMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    CsvSchema schema = CsvSchema.emptySchema().withHeader();

    ObjectReader oReader = csvMapper.reader(Weather.class).with(schema);
    List<Weather> weathers = new ArrayList<>();

    try (Reader reader = new FileReader(path)) {
      MappingIterator<Weather> mi = oReader.readValues(reader);
        while (mi.hasNext()) {
          Weather current = mi.next();
          current.init();
          weathers.add(current);
      }
    }

    return weathers;
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
