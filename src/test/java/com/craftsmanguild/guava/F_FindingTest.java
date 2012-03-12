package com.craftsmanguild.guava;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;

public class F_FindingTest {

  @Test
  public void findingWithoutGuava() {
    final ThingWithRawData expectedFirstThing = new ThingWithRawData(new BigDecimal("1234"), "first");
    final List<ThingWithRawData> rawThings = newArrayList(expectedFirstThing, new ThingWithRawData(new BigDecimal(
        "5678"), "second"), new ThingWithRawData(new BigDecimal("9012"), "third"));
    final List<ThingWithRawData> filteredThings = newArrayList();
    for (final ThingWithRawData thingWithRawData : rawThings) {
      if (thingWithRawData.getMonies().compareTo(new BigDecimal(4000)) >= 0) {
        filteredThings.add(thingWithRawData);
      }
    }

    final ThingWithRawData firstThing = filteredThings.get(0);

    assertThat(firstThing, is(firstThing));
  }

  @Test
  public void findingWithGuava() {
    final ThingWithRawData expectedFirstThing = new ThingWithRawData(new BigDecimal("1234"), "first");
    final List<ThingWithRawData> rawThings = newArrayList(expectedFirstThing, new ThingWithRawData(new BigDecimal(
        "5678"), "second"), new ThingWithRawData(new BigDecimal("9012"), "third"));

    final ThingWithRawData firstThing = find(rawThings, new ValuesGreaterThanFourThousandFilter());

    assertThat(firstThing, is(firstThing));
  }

  private final class ValuesGreaterThanFourThousandFilter implements Predicate<ThingWithRawData> {
    @Override
    public boolean apply(final ThingWithRawData thingWithRawData) {
      return thingWithRawData.getMonies().compareTo(new BigDecimal(4000)) >= 0;
    }
  }
}
