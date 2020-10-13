package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Example JUnit 5 test case.
 *
 * @author Benjamin Schmid benjamin.schmid@exxcellent.de
 */
class AppTest {

  /** Label which should be successful. */
  private String successLabel = "not successful";

  /** Runs before each test . */
  @BeforeEach
  void setUp() {
    successLabel = "successful";
  }

  /** A pointless Test. */
  @Test
  void pointlessTest() {
    assertEquals("successful", successLabel, "My expectations were not met");
  }

  /** Runs football. */
  @Test
  void runFootball() {
    App.main("--football", "football.csv");
  }

}
