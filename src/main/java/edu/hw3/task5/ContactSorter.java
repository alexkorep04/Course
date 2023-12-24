package edu.hw3.task5;

import java.util.Arrays;

public class ContactSorter {
    private ContactSorter() {
    }

    public static Contact[] parseContacts(String[] names, String order) {
        if (names == null) {
            return new Contact[0];
        }
        Contact[] contacts = new Contact[names.length];
        for (int i = 0; i < names.length; i++) {
            contacts[i] = new Contact(names[i]);
        }
        if ("ASC".equals(order)) {
            Arrays.sort(contacts, new ComparatorASC());
        } else {
            Arrays.sort(contacts, new ComparatorDESC());
        }
        return contacts;
    }
}
