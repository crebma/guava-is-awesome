package com.craftsmanguild.guava;

import static com.google.common.collect.Sets.*;

import java.util.Set;

import org.junit.Test;

public class C1_Sets {

  @Test
  public void whatsTheDifference() {
    final Set<String> first = newHashSet("a", "b", "c");
    final Set<String> second = newHashSet("b", "c", "d");

    System.out.println(difference(first, second));
  }

  @Test
  public void setOfTheUnion() {
    final Set<String> first = newHashSet("a", "b", "c");
    final Set<String> second = newHashSet("b", "c", "d");

    System.out.println(union(first, second));
  }

}
