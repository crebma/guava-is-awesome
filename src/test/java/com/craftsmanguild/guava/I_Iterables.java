package com.craftsmanguild.guava;

import static com.google.common.collect.Iterables.getFirst;
import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class I_Iterables {

  @Test
  public void iterablesCanGiveYouTheFirstThingInAnIterable() throws Exception {
    final List<String> list = newArrayList("first", "second");

    final String first = getFirst(list, null);

    assertThat(first, is("first"));
  }

  @Test
  public void iterablesCanGiveYouTheFirstThingInAnIterableSAFELY() throws Exception {
    final List<String> list = newArrayList();

    final String first = getFirst(list, "default");

    assertThat(first, is("default"));
  }
}
