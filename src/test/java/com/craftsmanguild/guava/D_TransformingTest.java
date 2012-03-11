package com.craftsmanguild.guava;

import static com.craftsmanguild.guava.Matchers.fancyThing;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;
import static java.lang.String.format;
import static java.text.NumberFormat.getCurrencyInstance;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;

@SuppressWarnings("unchecked")
public class D_TransformingTest {

  @Test
  public void transformingAListWithoutGuava() {
    final List<ThingWithRawData> rawThings = newArrayList(new ThingWithRawData(new BigDecimal("1234"), "first"),
        new ThingWithRawData(new BigDecimal("5678"), "second"), new ThingWithRawData(new BigDecimal("9012"), "third"));

    final List<FancyThing> fancyThings = newArrayList();
    for (final ThingWithRawData thingWithRawData : rawThings) {
      final String formatMonies = getCurrencyInstance().format(thingWithRawData.getMonies());
      final String formatThinger = format("this is a %s", thingWithRawData.getThinger());
      fancyThings.add(new FancyThing(formatMonies, formatThinger));
    }

    assertThat(
        fancyThings,
        contains(fancyThing("this is a first", "$1,234.00"), fancyThing("this is a second", "$5,678.00"),
            fancyThing("this is a third", "$9,012.00")));
  }

  @Test
  public void transformingAListWithGuava() {
    final List<ThingWithRawData> rawThings = newArrayList(new ThingWithRawData(new BigDecimal("1234"), "first"),
        new ThingWithRawData(new BigDecimal("5678"), "second"), new ThingWithRawData(new BigDecimal("9012"), "third"));

    final List<FancyThing> fancyThings = transform(rawThings, new ThingWithRawDataToFancyThingTransformer());

    assertThat(
        fancyThings,
        contains(fancyThing("this is a first", "$1,234.00"), fancyThing("this is a second", "$5,678.00"),
            fancyThing("this is a third", "$9,012.00")));
  }

  private final class ThingWithRawDataToFancyThingTransformer implements Function<ThingWithRawData, FancyThing> {
    @Override
    public FancyThing apply(final ThingWithRawData thingWithRawData) {
      final String formatMoney = getCurrencyInstance().format(thingWithRawData.getMonies());
      final String formatThinger = format("this is a %s", thingWithRawData.getThinger());
      return new FancyThing(formatMoney, formatThinger);
    }
  }
}
