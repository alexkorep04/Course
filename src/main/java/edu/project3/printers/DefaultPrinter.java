package edu.project3.printers;

import edu.project3.models.Table;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DefaultPrinter {

    StringBuilder printTable(Table table);

    StringBuilder printHeaders(Table table);

    StringBuilder printTableHeaders(Table table, Map<Integer, Integer> width);

    StringBuilder printAllLines(Table table, Map<Integer, Integer> width);

    default Map<Integer, Integer> getWidthOfColumn(Table table) {
        List<String> allLines = table.lines();
        Map<Integer, Integer> dict = new HashMap<>();
        List<String> tableHeaders = table.tableHeaders();
        for (int i = 0; i < tableHeaders.size(); i++) {
            dict.put(i, tableHeaders.get(i).length());
        }
        for (String line: allLines) {
            List<String> parts = Arrays.stream(line.split("!!!")).toList();
            for (int i = 0; i < parts.size(); i++) {
                if (dict.get(i) < parts.get(i).length()) {
                    dict.put(i,  parts.get(i).length());
                }
            }
        }
        return dict;
    }
}
