package de.exxcellent.challenge.entities;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class FootballGame {

  /** Name of the team. */
  private String team;
  /** ... */
  private int games;
  /** ... */
  private int wins;
  /** ... */
  private int losses;
  /** ... */
  private int draws;
  /** The goals. */
  private int goals;
  /** The allowed goals. */
  @JsonProperty("Goals Allowed") private int goalsAllowed;
  /** The goal-distance. */
  private Integer goalsDistance;
  /** ... */
  private int points;

  /** Default constructor for jackson-dataformat-csv. */
  public FootballGame() { }

  /**
   * @param dayArg - Day as a number.
   * @param goalsArg - Amount of goals.
   * @param goalsAllowedArg - Amount of allowed goals.
   */
  public FootballGame(final String dayArg,
  final int goalsArg, final int goalsAllowedArg) {
    this.team = dayArg;
    this.goals = goalsArg;
    this.goalsAllowed = goalsAllowedArg;

    init();
  }

  /** @return Returns itself after computing attributes. */
  public FootballGame init() {
    this.goalsDistance = Math.abs(goals - goalsAllowed);
    return this;
  }

  /**
   * @param footballGames - List with multiple FootballGame objects.
   * @return Sorted FootballGame objects in ascending order.
   */
  public static List<FootballGame> getFootballGameByGoalDistance(
    final List<FootballGame> footballGames) {
    return footballGames.stream()
      .sorted((p1, p2) ->
        p1.getGoalsDistance().compareTo(p2.getGoalsDistance()))
      .collect(Collectors.toList());
  }

  /**
   * @param footballGames - List with multiple FootballGame objects.
   * @return Day with the smallest amount of goals.
   */
  public static String getFootballGameWithSmallestGoalDistance(
    final List<FootballGame> footballGames) {
    return FootballGame.getFootballGameByGoalDistance(footballGames)
      .get(0).getTeam();
  }

  @Override
  public final String toString() {
    return ToStringBuilder.reflectionToString(this,
      ToStringStyle.MULTI_LINE_STYLE);
  }

  /** @return ... */
  public String getTeam() {
    return this.team;
  }

  /** @param teamArg - ... */
  public void setTeam(final String teamArg) {
    this.team = teamArg;
  }

  /** @return ... */
  public int getGames() {
    return this.games;
  }

  /** @param gamesArg - ... */
  public void setGames(final int gamesArg) {
    this.games = gamesArg;
  }

  /** @return ... */
  public int getWins() {
    return this.wins;
  }

  /** @param winsArg - ... */
  public void setWins(final int winsArg) {
    this.wins = winsArg;
  }

  /** @return ... */
  public int getLosses() {
    return this.losses;
  }

  /** @param lossesArg - ... */
  public void setLosses(final int lossesArg) {
    this.losses = lossesArg;
  }

  /** @return ... */
  public int getDraws() {
    return this.draws;
  }

  /** @param drawsArg - ... */
  public void setDraws(final int drawsArg) {
    this.draws = drawsArg;
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

  /** @return ... */
  public int getPoints() {
    return this.points;
  }

  /** @param pointsArg - ... */
  public void setPoints(final int pointsArg) {
    this.points = pointsArg;
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
