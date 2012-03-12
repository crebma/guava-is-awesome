package com.craftsmanguild.guava;

import static com.google.common.base.Predicates.notNull;
import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.Test;

public class I_IterablesTest {

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

  @Test
  public void iterablesCanGiveYouTheLastElementOfACollection() throws Exception {
    final List<String> list = newArrayList("first", "second", "third", "fourth");

    final String last = getLast(list);

    assertThat(last, is("fourth"));
  }

  @Test
  public void iterablesCanGiveYouTheLastElementOfACollectionSAFELY() throws Exception {
    final List<String> list = newArrayList();

    final String last = getLast(list, "default");

    assertThat(last, is("default"));
  }

  @Test
  public void iterablesCanGiveYouTheRestOfACollection() throws Exception {
    final List<String> list = newArrayList("first", "second", "third", "fourth");

    final List<String> rest = newArrayList(skip(list, 1));

    assertThat(rest, contains("second", "third", "fourth"));
  }

  @Test
  public void iterablesCanHelpYouSeeIfEverythingInACollectionMatchesACriteria() throws Exception {
    final List<String> list = newArrayList("first", "second", null, "third");

    final boolean noNulls = all(list, notNull());

    assertThat(noNulls, is(false));
  }

  @Test
  public void iterablesCanHelpYouSeeIfAnythingInACollectionMatchesACriteria() throws Exception {
    final List<String> list = newArrayList("first", "second", null, "third");

    final boolean anyNonNulls = any(list, notNull());

    assertThat(anyNonNulls, is(true));
  }

  @Test
  public void iterablesCanHelpYouSmashTogetherMultipleCollections() throws Exception {
    final List<String> list = newArrayList("first", "second");
    final Set<String> set = newHashSet("third", "fourth");

    final List<String> squashed = newArrayList(concat(list, set));

    assertThat(squashed, containsInAnyOrder("first", "second", "third", "fourth"));
  }

  @Test
  public void iterablesCanLimitACollection() throws Exception {
    final List<String> list = newArrayList("first", "second", "third", "fourth");

    final List<String> limitedList = newArrayList(limit(list, 3));

    assertThat(limitedList, contains("first", "second", "third"));
  }
}
