import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IntRangeFilterParameterizedTest {
  private static final int LOWER_BOUND = 2;
  private static final int UPPER_BOUND = 5;

  private IntRangeFilter filter;
  private int lowerBound;
  private int upperBound;
  private int value;
  private boolean expectedResult;

  private String message;

  // lowerBound, upperBound, value, expectedResult
  @Parameters(name = "{0}")
  public static Object[][] getData() {
    return new Object[][] {
      {
        "Левая граница входит", LOWER_BOUND, UPPER_BOUND, /* value= */ 2, /* expected= */ true
      },
      {"Левая граница не входит", LOWER_BOUND, UPPER_BOUND, 1, false},
      {"Правая граница входит", LOWER_BOUND, UPPER_BOUND, 5, true},
      {"Правая граница не входит", LOWER_BOUND, UPPER_BOUND, 6, false}
    };
  }

  public IntRangeFilterParameterizedTest(
      String message, int lowerBound, int upperBound, int value, boolean expectedResult) {
    this.message = message;
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
    this.value = value;
    this.expectedResult = expectedResult;
  }

  @Before
  public void setUp() {
    // Arrange
    filter = new IntRangeFilter(lowerBound, upperBound);
  }

  @Test
  public void filter() {
    // Act
    boolean actual = filter.filter(value);

    // Assert
    assertEquals(expectedResult, actual);
  }

  //  @Test
  //  public void filter_lowerBound_excluded() {
  //    boolean actual = filter.filter(1);
  //    assertFalse(actual);
  //  }
}
