package edu.hw3.task5;

import java.util.Comparator;

public class ComparatorDESC implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        String lastNameOfO1 = o1.getLastName();
        String lastNameOfO2 = o2.getLastName();
        if (lastNameOfO1 == null) {
            lastNameOfO1 = o1.getFirstName();
        }
        if (lastNameOfO2 == null) {
            lastNameOfO2 = o2.getFirstName();
        }
        return lastNameOfO2.compareTo(lastNameOfO1);
    }
}
