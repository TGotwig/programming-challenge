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
  /** The temperature-spread. */
  private Integer tempSpread;

  /**
   * @param dayArg - Day as a number.
   * @param maxTempArg - Maximum temperature
   * @param minTempArg - Minimum temperature
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
   * @param weathers - List with multiple Weather objects.
   * @return Day with the smallest temperature-spread.
   */
  public static String getDayWithSmallestSpread(final List<Weather> weathers) {
    return Weather.getWeathersByTempSpread(weathers).get(0).getDay();
  }

  @Override
  public final String toString() {
    return String.format(
      "{ day='%s', maxTemp='%s', minTemp='%s', tempSpread='%s' }",
      getDay(), getMaxTemp(), getMinTemp(), getTempSpread());
  }

  /** @return Day as a number. */
  public String getDay() {
    return this.day;
  }

  /** @param dayArg - Day as a number. */
  public void setDay(final String dayArg) {
    this.day = dayArg;
  }

  /** @return Maximum temperature. */
  public int getMaxTemp() {
    return this.maxTemp;
  }

  /** @param maxTempArg - Maximum temperature. */
  public void setMaxTemp(final int maxTempArg) {
    this.maxTemp = maxTempArg;
  }

  /** @return Minimum temperature. */
  public int getMinTemp() {
    return this.minTemp;
  }

  /** @param minTempArg - Minimum temperature. */
  public void setMinTemp(final int minTempArg) {
    this.minTemp = minTempArg;
  }

  /** @return Difference between maxTemp and minTemp. */
  public Integer getTempSpread() {
    return this.tempSpread;
  }

  /** @param tempSpreadArg - Difference between maxTemp and minTemp. */
  public void setTempSpread(final int tempSpreadArg) {
    this.tempSpread = tempSpreadArg;
  }

}
