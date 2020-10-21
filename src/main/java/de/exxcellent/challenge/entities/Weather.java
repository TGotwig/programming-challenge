package de.exxcellent.challenge.entities;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

  /** The day. */
  private int day;
  /** The maximum temperature. */
  private int mxt;
  /** The minimum temperature. */
  private int mnt;
  /** ... */
  private int avt;
  /** ... */
  private float avdp;
  /** ... */
  @JsonProperty("1HrP TPcpn") private int hrpTpcpn;
  /** ... */
  private int pdir;
  /** ... */
  private float avsp;
  /** ... */
  private int dir;
  /** ... */
  private int mxs;
  /** ... */
  private float skyc;
  /** ... */
  private int mxr;
  /** ... */
  private int mn;
  /** ... */
  @JsonProperty("R AvSLP") private float rAvslp;
  /** The temperature-spread. */
  private Integer tempSpread;

  /** Default constructor for jackson-dataformat-csv. */
  public Weather() { }

  /**
   * @param dayArg - Day as a number.
   * @param maxTempArg - Maximum temperature.
   * @param minTempArg - Minimum temperature.
   */
  public Weather(final int dayArg,
  final int maxTempArg, final int minTempArg) {
    this.day = dayArg;
    this.mxt = maxTempArg;
    this.mnt = minTempArg;

    this.init();
  }

  /** @return Returns itself after computing attributes. */
  public Weather init() {
    tempSpread = mxt - mnt;
    return this;
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
  public static int getDayWithSmallestSpread(final List<Weather> weathers) {
    return Weather.getWeathersByTempSpread(weathers).get(0).getDay();
  }

  @Override
  public final String toString() {
    return String.format(
      "{ day='%s', maxTemp='%s', minTemp='%s', tempSpread='%s' }",
      day, mxt, mnt, tempSpread);
  }

  // ------------------------------
  // Initial getters & setters
  // ------------------------------

  /** @return Day as a number. */
  public int getDay() {
    return this.day;
  }

  /** @param dayArg - Day as a number. */
  public void setDay(final int dayArg) {
    this.day = dayArg;
  }

  /** @return Maximum temperature. */
  public int getMxt() {
    return this.mxt;
  }

  /** @param maxTempArg - Maximum temperature. */
  public void setMxt(final int maxTempArg) {
    this.mxt = maxTempArg;
  }

  /** @return Minimum temperature. */
  public int getMnt() {
    return this.mnt;
  }

  /** @param minTempArg - Minimum temperature. */
  public void setMnt(final int minTempArg) {
    this.mnt = minTempArg;
  }

  /** @return ... */
  public int getAvt() {
    return this.avt;
  }

  /** @param avtArg - ... */
  public void setAvt(final int avtArg) {
    this.avt = avtArg;
  }

  /** @return ... */
  public float getAvdp() {
    return this.avdp;
  }

  /** @param avdpArg - ... */
  public void setAvdp(final float avdpArg) {
    this.avdp = avdpArg;
  }

  /** @return ... */
  public int getHrpTpcpn() {
    return this.hrpTpcpn;
  }

  /** @param hrpTpcpnArg - ... */
  public void setHrpTpcpn(final int hrpTpcpnArg) {
    this.hrpTpcpn = hrpTpcpnArg;
  }

  /** @return ... */
  public int getPdir() {
    return this.pdir;
  }

  /** @param pdirArg - ... */
  public void setPdir(final int pdirArg) {
    this.pdir = pdirArg;
  }

  /** @return ... */
  public float getAvsp() {
    return this.avsp;
  }

  /** @param avspArg - ... */
  public void setAvsp(final Float avspArg) {
    this.avsp = avspArg;
  }

  /** @return ... */
  public int getDir() {
    return this.dir;
  }

  /** @param dirArg - ... */
  public void setDir(final int dirArg) {
    this.dir = dirArg;
  }

  /** @return ... */
  public int getMxs() {
    return this.mxs;
  }

  /** @param mxsArg - ... */
  public void setMxs(final int mxsArg) {
    this.mxs = mxsArg;
  }

  /** @return ... */
  public float getSkyc() {
    return this.skyc;
  }

  /** @param skycArg - ... */
  public void setSkyc(final float skycArg) {
    this.skyc = skycArg;
  }

  /** @return ... */
  public int getMxr() {
    return this.mxr;
  }

  /** @param mxrArg - ... */
  public void setMxr(final int mxrArg) {
    this.mxr = mxrArg;
  }

  /** @return ... */
  public int getMn() {
    return this.mn;
  }

  /** @param mnArg - ... */
  public void setMn(final int mnArg) {
    this.mn = mnArg;
  }

  /** @return ... */
  public float getRAvslp() {
    return this.rAvslp;
  }

  /** @param rAvslpArg - ... */
  public void setRAvslp(final float rAvslpArg) {
    this.rAvslp = rAvslpArg;
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
