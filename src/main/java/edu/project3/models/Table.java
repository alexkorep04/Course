package edu.project3.models;

import java.util.List;

public record Table(String header, List<String> tableHeaders, List<String> lines) {
}
