package com.craftsmanguild.guava;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;
import static java.lang.String.format;
import static java.text.NumberFormat.getCurrencyInstance;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;

public class D_Transforming extends Z_BaseCrap {

  @Test
  public void transformingAListWithoutGuava() {
    System.out.println(thingWithRawDataToFancyThing(originalList()));
  }

  @Test
  public void transformingAListWithGuava() {
    System.out.println(transform(originalList(), new ThingWithRawDataToFancyThingTransformer()));
  }

  private List<FancyThing> thingWithRawDataToFancyThing(final List<ThingWithRawData> originalList) {
    final List<FancyThing> fancyThings = newArrayList();

    for (final ThingWithRawData thingWithRawData : originalList) {
      final String formatMonies = getCurrencyInstance().format(thingWithRawData.getMonies());
      final String formatThinger = format("this is a %s", thingWithRawData.getThinger());
      fancyThings.add(new FancyThing(formatMonies, formatThinger));
    }
    return fancyThings;
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
