package com.craftsmanguild.guava;

import static java.lang.String.format;

import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class Matchers {

  public static <K, V> Matcher<Map.Entry<K, V>> entry(final K key, final V value) {
    return new TypeSafeMatcher<Map.Entry<K, V>>() {
      @Override
      public void describeTo(final Description description) {
        description.appendText(format("an entry with key %d and value %s", key, value));
      }

      @Override
      protected boolean matchesSafely(final Entry<K, V> entry) {
        return key.equals(entry.getKey()) && value.equals(entry.getValue());
      }
    };

  }
}
