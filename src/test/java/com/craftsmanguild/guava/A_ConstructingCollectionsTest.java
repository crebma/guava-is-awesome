package com.craftsmanguild.guava;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class A_ConstructingCollectionsTest {

  @Test
  public void makingLists() {
    final List<List<List<String>>> guavalessList = new ArrayList<List<List<String>>>();
    final List<List<List<String>>> guavaList = newArrayList();

    assertThat(guavalessList, is(guavaList));
  }

  @Test
  public void makingSets() {
    final Set<Set<Set<String>>> guavalessSet = new HashSet<Set<Set<String>>>();
    final Set<Set<Set<String>>> guavaSet = newHashSet();

    assertThat(guavalessSet, is(guavaSet));
  }

  @Test
  public void makingMaps() {
    final Map<String, Map<String, Map<String, String>>> guavalessMap = new HashMap<String, Map<String, Map<String, String>>>();
    final Map<String, Map<String, Map<String, String>>> guavaMap = newHashMap();

    assertThat(guavalessMap, is(guavaMap));
  }
}
