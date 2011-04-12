package com.craftsmanguild.guava;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;

public class G_FindingWithDefaultValue extends Z_BaseCrap {

  @Test
  public void findingAThingThatDoesNotExistWithoutGuava() {
    final List<ThingWithRawData> filteredList = filterForValuesGreaterThanTenThousand(originalList());

    ThingWithRawData foundThinger = new ThingWithRawData(null, null);
    if (!filteredList.isEmpty()) {
      foundThinger = filteredList.get(0);
    }

    System.out.println(foundThinger);
  }

  @Test
  public void findingAThingThatDoesNotExistWithGuava() {
    System.out
        .println(find(originalList(), new ValuesGreaterThanTenThousandFilter(), new ThingWithRawData(null, null)));
  }

  private List<ThingWithRawData> filterForValuesGreaterThanTenThousand(final List<ThingWithRawData> originalList) {
    final List<ThingWithRawData> filteredList = newArrayList();

    for (final ThingWithRawData thingWithRawData : originalList) {
      if (thingWithRawData.getMonies().compareTo(tenThousand()) >= 0) {
        filteredList.add(thingWithRawData);
      }
    }
    return filteredList;
  }

  private final class ValuesGreaterThanTenThousandFilter implements Predicate<ThingWithRawData> {
    @Override
    public boolean apply(final ThingWithRawData thingWithRawData) {
      return thingWithRawData.getMonies().compareTo(tenThousand()) >= 0;
    }
  }
}
