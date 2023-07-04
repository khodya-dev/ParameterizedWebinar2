public class IntRangeFilter {
  private int lowerBound;  // нижняя граница
  private int upperBound;  // верхняя граница

  public IntRangeFilter(int lowerBound, int upperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  public boolean filter(int value) {
    return value >= lowerBound && value <= upperBound;
  }
}
