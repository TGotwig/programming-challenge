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

  private Helpers() {
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

  public static List<FootballGame> createFootballGamesFromCsv(
  final String path) throws IOException {
    CsvMapper csvMapper = new CsvMapper();
    csvMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    CsvSchema schema = CsvSchema.emptySchema().withHeader();

    ObjectReader oReader = csvMapper.reader(FootballGame.class).with(schema);
    List<FootballGame> footballGames = new ArrayList<>();

    try (Reader reader = new FileReader(path)) {
      MappingIterator<FootballGame> mi = oReader.readValues(reader);
        while (mi.hasNext()) {
          FootballGame current = mi.next();
          current.init();
          footballGames.add(current);
      }
    }

    return footballGames;
  }

}
