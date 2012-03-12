package com.craftsmanguild.guava;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;

public class G_FindingWithDefaultValueTest {

  @Test
  public void findingAThingThatDoesNotExistWithoutGuava() {
    final List<ThingWithRawData> rawThings = newArrayList(new ThingWithRawData(new BigDecimal("1234"), "first"),
        new ThingWithRawData(new BigDecimal("5678"), "second"), new ThingWithRawData(new BigDecimal("9012"), "third"));
    final List<ThingWithRawData> filteredThingers = newArrayList();

    for (final ThingWithRawData thingWithRawData : rawThings) {
      if (thingWithRawData.getMonies().compareTo(new BigDecimal(10000)) >= 0) {
        filteredThingers.add(thingWithRawData);
      }
    }
    ThingWithRawData foundThinger = new ThingWithRawData(null, null);
    if (!filteredThingers.isEmpty()) {
      foundThinger = filteredThingers.get(0);
    }

    assertThat(foundThinger.getMonies(), is(nullValue()));
    assertThat(foundThinger.getThinger(), is(nullValue()));
  }

  @Test
  public void findingAThingThatDoesNotExistWithGuava() {
    final List<ThingWithRawData> rawThings = newArrayList(new ThingWithRawData(new BigDecimal("1234"), "first"),
        new ThingWithRawData(new BigDecimal("5678"), "second"), new ThingWithRawData(new BigDecimal("9012"), "third"));

    final ThingWithRawData foundThinger = find(rawThings, new ValuesGreaterThanTenThousandFilter(),
        new ThingWithRawData(null, null));

    assertThat(foundThinger.getMonies(), is(nullValue()));
    assertThat(foundThinger.getThinger(), is(nullValue()));
  }

  private final class ValuesGreaterThanTenThousandFilter implements Predicate<ThingWithRawData> {
    @Override
    public boolean apply(final ThingWithRawData thingWithRawData) {
      return thingWithRawData.getMonies().compareTo(new BigDecimal(10000)) >= 0;
    }
  }
}
