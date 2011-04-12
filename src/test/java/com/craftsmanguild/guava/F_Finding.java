package com.craftsmanguild.guava;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;

public class F_Finding extends Z_BaseCrap {

  @Test
  public void findingWithoutGuava() {
    System.out.println(filterForValuesGreaterThanFourThousand(originalList()).get(0));
  }

  @Test
  public void findingWithGuava() {
    System.out.println(find(originalList(), new ValuesGreaterThanFourThousandFilter()));
  }

  private List<ThingWithRawData> filterForValuesGreaterThanFourThousand(final List<ThingWithRawData> originalList) {
    final List<ThingWithRawData> filteredList = newArrayList();

    for (final ThingWithRawData thingWithRawData : originalList) {
      if (thingWithRawData.getMonies().compareTo(fourThousand()) >= 0) {
        filteredList.add(thingWithRawData);
      }
    }
    return filteredList;
  }

  private final class ValuesGreaterThanFourThousandFilter implements Predicate<ThingWithRawData> {
    @Override
    public boolean apply(final ThingWithRawData thingWithRawData) {
      return thingWithRawData.getMonies().compareTo(fourThousand()) >= 0;
    }
  }
}
