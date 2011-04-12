package com.craftsmanguild.guava;

import static com.google.common.collect.Lists.newArrayList;

import java.math.BigDecimal;
import java.util.List;

public class Z_BaseCrap {

  public List<ThingWithRawData> originalList() {
    return newArrayList(new ThingWithRawData(new BigDecimal("1234"), "first"), new ThingWithRawData(new BigDecimal(
        "5678"), "second"), new ThingWithRawData(new BigDecimal("9012"), "third"));
  }

  public BigDecimal fourThousand() {
    return new BigDecimal(4000);
  }

  public BigDecimal tenThousand() {
    return new BigDecimal(10000);
  }
}
