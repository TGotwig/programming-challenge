package de.exxcellent.challenge.entities;

import java.util.List;
import java.util.stream.Collectors;

public class Weather {

  /** The day. */
  private String day;
  /** The maximum temperature. */
  private int maxTemp;
  /** The minimum temperature. */
  private int minTemp;
  /** The minimum temperature. */
  private Integer tempSpread;

  /**
   * @param dayArg
   * @param maxTempArg - maximum temperature
   * @param minTempArg - minimum temperature
   */
  public Weather(final String dayArg,
  final int maxTempArg, final int minTempArg) {
    this.day = dayArg;
    this.maxTemp = maxTempArg;
    this.minTemp = minTempArg;

    this.tempSpread = maxTempArg - minTempArg;
  }

  /**
   * @param weathers - A list containing multiple weather objects.
   * @return Sorted weather objects in ascending order.
   */
  public static List<Weather> getWeathersByTempSpread(
    final List<Weather> weathers) {
    return weathers.stream()
      .sorted((p1, p2) -> p1.getTempSpread().compareTo(p2.getTempSpread()))
      .collect(Collectors.toList());
  }

  /**
   * @param weathers - A list containing multiple weather objects.
   * @return The day with the lowest temperature-spread.
   */
  public static String getDayWithLowestSpread(final List<Weather> weathers) {
    return Weather.getWeathersByTempSpread(weathers).get(0).getDay();
  }

  @Override
  public final String toString() {
    return String.format(
      "{ day='%s', maxTemp='%s', minTemp='%s', tempSpread='%s' }",
      getDay(), getMaxTemp(), getMinTemp(), getTempSpread());
  }

  /** @return The day. */
  public String getDay() {
    return this.day;
  }

  /** @param dayArg */
  public void setDay(final String dayArg) {
    this.day = dayArg;
  }

  /** @return The maximum temperature. */
  public int getMaxTemp() {
    return this.maxTemp;
  }

  /** @param maxTempArg */
  public void setMaxTemp(final int maxTempArg) {
    this.maxTemp = maxTempArg;
  }

  /** @return The minimum temperature. */
  public int getMinTemp() {
    return this.minTemp;
  }

  /** @param minTempArg */
  public void setMinTemp(final int minTempArg) {
    this.minTemp = minTempArg;
  }

  /** @return The difference between maxTemp and minTemp. */
  public Integer getTempSpread() {
    return this.tempSpread;
  }

  /** @param tempSpreadArg */
  public void setTempSpread(final int tempSpreadArg) {
    this.tempSpread = tempSpreadArg;
  }

}
