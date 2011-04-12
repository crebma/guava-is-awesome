package com.craftsmanguild.guava;

import java.math.BigDecimal;

import com.google.common.base.Objects;

public class ThingWithRawData {

  private final BigDecimal monies;
  private final String thinger;

  public ThingWithRawData(final BigDecimal monies, final String thinger) {
    this.monies = monies;
    this.thinger = thinger;
  }

  public BigDecimal getMonies() {
    return monies;
  }

  public String getThinger() {
    return thinger;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(getClass()).addValue(thinger).addValue(monies).toString();
  }
}
