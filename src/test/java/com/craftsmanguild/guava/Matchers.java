package com.craftsmanguild.guava;

import static com.google.common.base.Objects.equal;
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
        return equal(key, entry.getKey()) && equal(value, entry.getValue());
      }
    };

  }

  public static Matcher<FancyThing> fancyThing(final String thinger, final String money) {
    return new TypeSafeMatcher<FancyThing>() {
      @Override
      public void describeTo(final Description description) {
        description.appendText(format("FancyThing{%s, %s}", money, thinger));
      }

      @Override
      protected boolean matchesSafely(final FancyThing fancyThing) {
        return equal(money, fancyThing.getFormattedMoney()) && equal(thinger, fancyThing.getFormattedThinger());
      }
    };
  }
}
