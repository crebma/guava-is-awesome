package com.craftsmanguild.guava;

import static com.craftsmanguild.guava.Matchers.entry;
import static com.google.common.collect.Maps.*;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

@SuppressWarnings("unchecked")
public class C2_MapsTest {

  private Map<Integer, String> map;

  @Before
  public void setUp() {
    map = newHashMap();
    map.put(1, "a");
    map.put(2, "b");
    map.put(3, "c");
    map.put(4, "d");
  }

  @Test
  public void filterMapKeys() {
    final Map<Integer, String> filteredMap = filterKeys(map, new Predicate<Integer>() {
      @Override
      public boolean apply(final Integer key) {
        return key > 2;
      }
    });

    assertThat(filteredMap.entrySet(), contains(entry(3, "c"), entry(4, "d")));
  }

  @Test
  public void filterMapValues() {
    final Map<Integer, String> filteredMap = filterValues(map, new Predicate<String>() {
      @Override
      public boolean apply(final String value) {
        return "a".equals(value) || "b".equals(value);
      }
    });

    assertThat(filteredMap.entrySet(), contains(entry(1, "a"), entry(2, "b")));
  }

  @Test
  public void transformValues() {
    final Map<Integer, Character> transformedMap = Maps.transformValues(map, new Function<String, Character>() {
      @Override
      public Character apply(final String value) {
        return value.charAt(0);
      }
    });

    assertThat(transformedMap.entrySet(), contains(entry(1, 'a'), entry(2, 'b'), entry(3, 'c'), entry(4, 'd')));
  }

}
