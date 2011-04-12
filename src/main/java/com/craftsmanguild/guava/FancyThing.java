package com.craftsmanguild.guava;

import com.google.common.base.Objects;

public class FancyThing {

  private final String formattedMoney;
  private final String formattedThinger;

  public FancyThing(final String formattedMoney, final String formattedThinger) {
    this.formattedMoney = formattedMoney;
    this.formattedThinger = formattedThinger;
  }

  public String getFormattedMoney() {
    return formattedMoney;
  }

  public String getFormattedThinger() {
    return formattedThinger;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this.getClass()).addValue(formattedThinger).addValue(formattedMoney).toString();
  }
}
