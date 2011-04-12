package com.craftsmanguild.guava;

import static com.google.common.collect.HashBasedTable.create;
import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Table;
import com.google.common.collect.Tables;

public class B_Tables {

  private static final List<String> ROWS = asList("a", "b", "c", "d");
  private static final List<String> COLUMNS = asList("1", "2", "3", "4");

  @Test
  public void speakingOfMapsOfMaps_noGuava() {
    final Map<String, Map<String, String>> rowToColumn = new HashMap<String, Map<String, String>>();
    for (final String row : ROWS) {
      if (!rowToColumn.containsKey(row)) {
        rowToColumn.put(row, new HashMap<String, String>());
      }
      final Map<String, String> columnAndValue = rowToColumn.get(row);
      for (final String column : COLUMNS) {
        columnAndValue.put(column, row + column);
      }
    }

    final Map<String, String> rowA = rowToColumn.get("a");
    if (rowA != null) {
      final String valueForColumn2 = rowA.get("2");
      System.out.println(valueForColumn2.length());
    }
  }

  @Test
  public void speakingOfMapsOfMaps_table() {
    final Table<String, String, String> rowToColumn = create();
    for (final String row : ROWS) {
      for (final String column : COLUMNS) {
        rowToColumn.put(row, column, row + column);
      }
    }

    System.out.println(rowToColumn.get("a", "2"));

    final Table<String, String, String> columnToRow = Tables.transpose(rowToColumn);

    System.out.println(columnToRow.get("2", "a"));
  }
}
