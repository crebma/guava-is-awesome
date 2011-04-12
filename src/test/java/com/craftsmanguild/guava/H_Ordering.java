package com.craftsmanguild.guava;

import org.junit.Test;

import com.google.common.collect.Ordering;

public class H_Ordering extends Z_BaseCrap {

  @Test
  public void customOrdering() {
    System.out.println(new SortByMonies().sortedCopy(originalList()));
  }

  @Test
  public void toTheMax() {
    System.out.println(new SortByMonies().greatestOf(originalList(), 1));
  }

  @Test
  public void reverseOrdering() {
    System.out.println(new SortByMonies().reverse().sortedCopy(originalList()));
  }

  private final class SortByMonies extends Ordering<ThingWithRawData> {
    @Override
    public int compare(final ThingWithRawData left, final ThingWithRawData right) {
      return left.getMonies().compareTo(right.getMonies());
    }
  }
}
