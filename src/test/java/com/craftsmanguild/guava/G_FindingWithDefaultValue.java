package com.craftsmanguild.guava;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newArrayList;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;

public class G_FindingWithDefaultValue {

  @Test
  public void findingAThingThatDoesNotExistWithoutGuava() {
    final List<ThingWithRawData> filteredList = filterForValuesGreaterThanTenThousand(newArrayList(
        new ThingWithRawData(new BigDecimal("1234"), "first"), new ThingWithRawData(new BigDecimal("5678"), "second"),
        new ThingWithRawData(new BigDecimal("9012"), "third")));

    ThingWithRawData foundThinger = new ThingWithRawData(null, null);
    if (!filteredList.isEmpty()) {
      foundThinger = filteredList.get(0);
    }

    System.out.println(foundThinger);
  }

  @Test
  public void findingAThingThatDoesNotExistWithGuava() {
    System.out.println(find(
        newArrayList(new ThingWithRawData(new BigDecimal("1234"), "first"), new ThingWithRawData(
            new BigDecimal("5678"), "second"), new ThingWithRawData(new BigDecimal("9012"), "third")),
        new ValuesGreaterThanTenThousandFilter(), new ThingWithRawData(null, null)));
  }

  private List<ThingWithRawData> filterForValuesGreaterThanTenThousand(final List<ThingWithRawData> originalList) {
    final List<ThingWithRawData> filteredList = newArrayList();

    for (final ThingWithRawData thingWithRawData : originalList) {
      if (thingWithRawData.getMonies().compareTo(new BigDecimal(10000)) >= 0) {
        filteredList.add(thingWithRawData);
      }
    }
    return filteredList;
  }

  private final class ValuesGreaterThanTenThousandFilter implements Predicate<ThingWithRawData> {
    @Override
    public boolean apply(final ThingWithRawData thingWithRawData) {
      return thingWithRawData.getMonies().compareTo(new BigDecimal(10000)) >= 0;
    }
  }
}
