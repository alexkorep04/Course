package edu.project3.printers;

import edu.project3.models.Table;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Markdown implements DefaultPrinter {
    @Override
    public StringBuilder printTable(Table table) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(printHeaders(table));
        stringBuilder.append(printTableHeaders(table, getWidthOfColumn(table)));
        stringBuilder.append(printAllLines(table, getWidthOfColumn(table)));
        return stringBuilder;
    }

    @Override
    public StringBuilder printHeaders(Table table) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("### ");
        stringBuilder.append(table.header());
        stringBuilder.append("\n");
        return stringBuilder;
    }

    @Override
    public StringBuilder printTableHeaders(Table table, Map<Integer, Integer> width) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> tableHeaders = table.tableHeaders();
        for (int i = 0; i < width.size(); i++) {
            stringBuilder.append("|");
            stringBuilder.append(tableHeaders.get(i));
            for (int j = 0; j <= width.get(i) - tableHeaders.get(i).length(); j++) {
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append("|");
        stringBuilder.append("\n");
        stringBuilder.append("|");
        for (int i = 0; i < width.size(); i++) {
            stringBuilder.append(":");
            for (int j = 1; j < width.get(i); j++) {
                stringBuilder.append("-");
            }
            stringBuilder.append(":|");
        }
        stringBuilder.append("\n");
        return stringBuilder;
    }

    @Override
    public StringBuilder printAllLines(Table table, Map<Integer, Integer> width) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> allLines = table.lines();
        for (int i = 0; i < allLines.size(); i++) {
            List<String> parts = Arrays.stream(allLines.get(i).split("!!!")).toList();
            for (int j = 0; j < parts.size(); j++) {
                stringBuilder.append("|");
                stringBuilder.append(parts.get(j));
                if (width.get(j) != null) {
                    for (int k = 0; k <= width.get(j) - parts.get(j).length(); k++) {
                        stringBuilder.append(" ");
                    }
                }
            }
            stringBuilder.append("|");
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }
}
