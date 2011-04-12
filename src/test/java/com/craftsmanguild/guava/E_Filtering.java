package com.craftsmanguild.guava;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;

public class E_Filtering extends Z_BaseCrap {

  @Test
  public void filteringACollectionWithoutGuava() {
    System.out.println(filterForValuesGreaterThanFourThousand(originalList()));
  }

  @Test
  public void filteringACollectionWithGuava() {
    System.out.println(filter(originalList(), new ValuesGreaterThanFourThousandFilter()));
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
