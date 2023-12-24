package edu.hw3;

import edu.hw3.task5.Contact;
import edu.hw3.task5.ContactSorter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Test sorting in ASC by last name")
    public void testASCSortByLastName()
    {
        String[] contacts = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};

        Contact[] expected = {new Contact("Thomas Aquinas"), new Contact("Rene Descartes"), new Contact("David Hume"), new Contact("John Locke")};

        Contact[] response = ContactSorter.parseContacts(contacts, "ASC");
        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test sorting in DESC by last name")
    public void testDESCSortByLastName()
    {
        String[] contacts = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};

        Contact[] expected = {new Contact("John Locke"), new Contact("David Hume"), new Contact("Rene Descartes"), new Contact("Thomas Aquinas")};

        Contact[] response = ContactSorter.parseContacts(contacts, "DESC");
        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test sorting in DESC  where one contact has only first name")
    public void testDESCSortByLastAndFirstName()
    {
        String[] contacts = {"John Locke", "Thomas Aquinas", "David", "Rene Descartes"};

        Contact[] expected = {new Contact("John Locke"), new Contact("Rene Descartes"), new Contact("David"), new Contact("Thomas Aquinas")};

        Contact[] response = ContactSorter.parseContacts(contacts, "DESC");
        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test sorting in ASC empty contact array")
    public void testASCSortEmpty()
    {
        String[] contacts = {};

        Contact[] expected = {};

        Contact[] response = ContactSorter.parseContacts(contacts, "ASC");
        assertThat(response).isEqualTo(expected);
    }
}
