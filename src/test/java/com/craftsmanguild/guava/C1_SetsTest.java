package com.craftsmanguild.guava;

import static com.google.common.collect.Sets.*;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Test;

public class C1_SetsTest {

  @Test
  public void whatsTheDifference() {
    final Set<String> first = newHashSet("a", "b", "c");
    final Set<String> second = newHashSet("b", "c", "d");

    assertThat(difference(first, second), contains("a"));
  }

  @Test
  public void setOfTheUnion() {
    final Set<String> first = newHashSet("a", "b", "c");
    final Set<String> second = newHashSet("b", "c", "d");

    assertThat(union(first, second), contains("b", "c", "a", "d"));
  }

}
