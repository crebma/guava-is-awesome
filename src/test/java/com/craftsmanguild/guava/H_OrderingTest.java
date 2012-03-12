package com.craftsmanguild.guava;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Ordering;

public class H_OrderingTest {

  @Test
  public void customOrdering() {
    final ThingWithRawData firstThing = new ThingWithRawData(new BigDecimal("9012"), "third");
    final ThingWithRawData secondThing = new ThingWithRawData(new BigDecimal("5678"), "second");
    final ThingWithRawData thirdThing = new ThingWithRawData(new BigDecimal("1234"), "first");
    final List<ThingWithRawData> rawThings = newArrayList(firstThing, secondThing, thirdThing);

    final List<ThingWithRawData> sortedThings = new SortByMonies().sortedCopy(rawThings);

    assertThat(sortedThings, contains(thirdThing, secondThing, firstThing));
  }

  @Test
  public void toTheMax() {
    final ThingWithRawData firstThing = new ThingWithRawData(new BigDecimal("9012"), "third");
    final ThingWithRawData secondThing = new ThingWithRawData(new BigDecimal("5678"), "second");
    final ThingWithRawData thirdThing = new ThingWithRawData(new BigDecimal("1234"), "first");
    final List<ThingWithRawData> rawThings = newArrayList(firstThing, secondThing, thirdThing);

    final List<ThingWithRawData> greatestThings = new SortByMonies().greatestOf(rawThings, 1);

    assertThat(greatestThings, contains(firstThing));
  }

  @Test
  public void reverseOrdering() {
    final ThingWithRawData firstThing = new ThingWithRawData(new BigDecimal("9012"), "third");
    final ThingWithRawData secondThing = new ThingWithRawData(new BigDecimal("5678"), "second");
    final ThingWithRawData thirdThing = new ThingWithRawData(new BigDecimal("1234"), "first");
    final List<ThingWithRawData> rawThings = newArrayList(firstThing, secondThing, thirdThing);

    final List<ThingWithRawData> reverseSortedThings = new SortByMonies().reverse().sortedCopy(rawThings);

    assertThat(reverseSortedThings, contains(firstThing, secondThing, thirdThing));
  }

  private final class SortByMonies extends Ordering<ThingWithRawData> {
    @Override
    public int compare(final ThingWithRawData left, final ThingWithRawData right) {
      return left.getMonies().compareTo(right.getMonies());
    }
  }
}
