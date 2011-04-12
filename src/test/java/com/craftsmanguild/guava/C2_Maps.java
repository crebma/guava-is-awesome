package com.craftsmanguild.guava;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

public class C2_Maps {

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
    System.out.println(filterKeys(map, new Predicate<Integer>() {
      @Override
      public boolean apply(final Integer key) {
        return key > 2;
      }
    }));
  }

  @Test
  public void filterMapValues() {
    System.out.println(filterValues(map, new Predicate<String>() {
      @Override
      public boolean apply(final String value) {
        return "a".equals(value) || "b".equals(value);
      }
    }));
  }

  @Test
  public void transformValues() {
    System.out.println(Maps.transformValues(map, new Function<String, Character>() {
      @Override
      public Character apply(final String value) {
        return value.charAt(0);
      }
    }));
  }
}
