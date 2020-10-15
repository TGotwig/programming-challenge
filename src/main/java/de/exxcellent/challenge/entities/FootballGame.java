package de.exxcellent.challenge.entities;

import java.util.List;
import java.util.stream.Collectors;

public class FootballGame {

  /** The day. */
  private String day;
  /** The goals. */
  private int goals;
  /** The allowed goals. */
  private int goalsAllowed;
  /** The goal-distance. */
  private Integer goalsDistance;

  /**
   * @param dayArg - Day as a number.
   * @param goalsArg - Amount of goals.
   * @param goalsAllowedArg - Amount of allowed goals.
   */
  public FootballGame(final String dayArg,
  final int goalsArg, final int goalsAllowedArg) {
    this.day = dayArg;
    this.goals = goalsArg;
    this.goalsAllowed = goalsAllowedArg;

    this.goalsDistance = Math.abs(goals - goalsAllowed);
  }

  /**
   * @param footballGames - List with multiple FootballGame objects.
   * @return Sorted FootballGame objects in ascending order.
   */
  public static List<FootballGame> getWeathersByTempSpread(
    final List<FootballGame> footballGames) {
    return footballGames.stream()
      .sorted((p1, p2) ->
        p1.getGoalsDistance().compareTo(p2.getGoalsDistance()))
      .collect(Collectors.toList());
  }

  /**
   * @param weathers - List with multiple FootballGame objects.
   * @return Day with the lowest amount of goals.
   */
  public static String getDayWithLowestSpread(
    final List<FootballGame> weathers) {
    return FootballGame.getWeathersByTempSpread(weathers).get(0).getDay();
  }

  @Override
  public final String toString() {
    return String.format(
      "{ day='%s', goals='%s', goalsAllowed='%s', goalsDistance='%s' }",
      getDay(), getGoals(), getGoalsAllowed(), getGoalsDistance());
  }

  /** @return Day as a number. */
  public String getDay() {
    return this.day;
  }

  /** @param dayArg - Day as a number. */
  public void setDay(final String dayArg) {
    this.day = dayArg;
  }

  /** @return Amount of goals. */
  public int getGoals() {
    return this.goals;
  }

  /** @param goalsArg - Amount of goals. */
  public void setGoals(final int goalsArg) {
    this.goals = goalsArg;
  }

  /** @return Amount of allowed goals. */
  public int getGoalsAllowed() {
    return this.goalsAllowed;
  }

  /** @param goalsAllowedArg - Amount of allowed goals. */
  public void setMinTemp(final int goalsAllowedArg) {
    this.goalsAllowed = goalsAllowedArg;
  }

  /** @return Difference between maxTemp and minTemp. */
  public Integer getGoalsDistance() {
    return this.goalsDistance;
  }

  /** @param tempSpreadArg - Difference between maxTemp and minTemp. */
  public void setGoalsDistance(final int tempSpreadArg) {
    this.goalsDistance = tempSpreadArg;
  }

}
