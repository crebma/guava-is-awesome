package com.craftsmanguild.guava;

import static com.google.common.collect.Lists.newArrayList;

import java.math.BigDecimal;

import org.junit.Test;

import com.google.common.collect.Ordering;

public class H_Ordering {

  @Test
  public void customOrdering() {
    System.out.println(new SortByMonies().sortedCopy(newArrayList(
        new ThingWithRawData(new BigDecimal("1234"), "first"), new ThingWithRawData(new BigDecimal("5678"), "second"),
        new ThingWithRawData(new BigDecimal("9012"), "third"))));
  }

  @Test
  public void toTheMax() {
    System.out.println(new SortByMonies().greatestOf(
        newArrayList(new ThingWithRawData(new BigDecimal("1234"), "first"), new ThingWithRawData(
            new BigDecimal("5678"), "second"), new ThingWithRawData(new BigDecimal("9012"), "third")), 1));
  }

  @Test
  public void reverseOrdering() {
    System.out.println(new SortByMonies().reverse().sortedCopy(
        newArrayList(new ThingWithRawData(new BigDecimal("1234"), "first"), new ThingWithRawData(
            new BigDecimal("5678"), "second"), new ThingWithRawData(new BigDecimal("9012"), "third"))));
  }

  private final class SortByMonies extends Ordering<ThingWithRawData> {
    @Override
    public int compare(final ThingWithRawData left, final ThingWithRawData right) {
      return left.getMonies().compareTo(right.getMonies());
    }
  }
}
