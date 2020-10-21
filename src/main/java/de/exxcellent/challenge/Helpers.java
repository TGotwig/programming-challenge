package de.exxcellent.challenge;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import de.exxcellent.challenge.entities.FootballGame;
import de.exxcellent.challenge.entities.Weather;

final class Helpers {
  /** Initializes the csv-mapper for parsing input. */
  private static CsvMapper csvMapper = new CsvMapper();
  static {
    csvMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
  }

  private Helpers() {
  }

  public static List<Weather> createWeathersFromCsv(final String path)
  throws IOException {
    ObjectReader oReader = csvMapper.readerFor(Weather.class).with(
      CsvSchema.emptySchema().withHeader());
    List<Weather> weathers = new ArrayList<>();

    try (Reader reader = new FileReader(path)) {
      MappingIterator<Weather> mi = oReader.readValues(reader);
      while (mi.hasNext()) {
        weathers.add(mi.next().init());
      }
    }

    return weathers;
  }

  public static List<FootballGame> createFootballGamesFromCsv(
  final String path) throws IOException {
    ObjectReader oReader = csvMapper.readerFor(FootballGame.class).with(
      CsvSchema.emptySchema().withHeader());
    List<FootballGame> footballGames = new ArrayList<>();

    try (Reader reader = new FileReader(path)) {
      MappingIterator<FootballGame> mi = oReader.readValues(reader);
        while (mi.hasNext()) {
          footballGames.add(mi.next().init());
        }
    }

    return footballGames;
  }

}
