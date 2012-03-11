package com.craftsmanguild.guava;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;

public class E_FilteringTest {

  @Test
  public void filteringACollectionWithoutGuava() {
    final ThingWithRawData firstThing = new ThingWithRawData(new BigDecimal("1234"), "first");
    final ThingWithRawData secondThing = new ThingWithRawData(new BigDecimal("5678"), "second");
    final ThingWithRawData thirdThing = new ThingWithRawData(new BigDecimal("9012"), "third");

    final List<ThingWithRawData> rawThings = newArrayList(firstThing, secondThing, thirdThing);
    final List<ThingWithRawData> filteredThings = newArrayList();
    for (final ThingWithRawData thingWithRawData : rawThings) {
      if (thingWithRawData.getMonies().compareTo(new BigDecimal(4000)) >= 0) {
        filteredThings.add(thingWithRawData);
      }
    }

    assertThat(filteredThings, contains(secondThing, thirdThing));
  }

  @Test
  public void filteringACollectionWithGuava() {
    final ThingWithRawData firstThing = new ThingWithRawData(new BigDecimal("1234"), "first");
    final ThingWithRawData secondThing = new ThingWithRawData(new BigDecimal("5678"), "second");
    final ThingWithRawData thirdThing = new ThingWithRawData(new BigDecimal("9012"), "third");

    final List<ThingWithRawData> rawThings = newArrayList(firstThing, secondThing, thirdThing);
    final Iterable<ThingWithRawData> filteredThings = filter(rawThings, new ValuesGreaterThanFourThousandFilter());

    assertThat(filteredThings, contains(secondThing, thirdThing));
  }

  private final class ValuesGreaterThanFourThousandFilter implements Predicate<ThingWithRawData> {
    @Override
    public boolean apply(final ThingWithRawData thingWithRawData) {
      return thingWithRawData.getMonies().compareTo(new BigDecimal(4000)) >= 0;
    }
  }
}
