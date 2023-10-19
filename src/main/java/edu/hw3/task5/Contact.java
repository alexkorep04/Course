package edu.hw3.task5;

import java.util.Objects;

public class Contact {
    private String firstName;
    private String lastName;

    public Contact(String fullName) {
        String[] parts = fullName.split(" ");
        if (parts.length == 2) {
            this.firstName = parts[0];
            this.lastName = parts[1];
        } else {
            this.firstName = "";
            this.lastName = fullName;
        }
    }

    public String getFullName() {
        if(firstName.length() != 0)
        {
            return firstName + " " + lastName;
        }
        return lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override public String toString() {
        return "Contact{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
