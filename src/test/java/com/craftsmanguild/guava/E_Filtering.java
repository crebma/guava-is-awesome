package com.craftsmanguild.guava;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;

public class E_Filtering {

  @Test
  public void filteringACollectionWithoutGuava() {
    System.out.println(filterForValuesGreaterThanFourThousand(newArrayList(new ThingWithRawData(new BigDecimal("1234"),
        "first"), new ThingWithRawData(new BigDecimal("5678"), "second"), new ThingWithRawData(new BigDecimal("9012"),
        "third"))));
  }

  @Test
  public void filteringACollectionWithGuava() {
    System.out.println(filter(
        newArrayList(new ThingWithRawData(new BigDecimal("1234"), "first"), new ThingWithRawData(
            new BigDecimal("5678"), "second"), new ThingWithRawData(new BigDecimal("9012"), "third")),
        new ValuesGreaterThanFourThousandFilter()));
  }

  private List<ThingWithRawData> filterForValuesGreaterThanFourThousand(final List<ThingWithRawData> originalList) {
    final List<ThingWithRawData> filteredList = newArrayList();

    for (final ThingWithRawData thingWithRawData : originalList) {
      if (thingWithRawData.getMonies().compareTo(new BigDecimal(4000)) >= 0) {
        filteredList.add(thingWithRawData);
      }
    }
    return filteredList;
  }

  private final class ValuesGreaterThanFourThousandFilter implements Predicate<ThingWithRawData> {
    @Override
    public boolean apply(final ThingWithRawData thingWithRawData) {
      return thingWithRawData.getMonies().compareTo(new BigDecimal(4000)) >= 0;
    }
  }
}
