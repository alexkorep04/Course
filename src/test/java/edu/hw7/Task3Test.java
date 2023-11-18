package edu.hw7;

import edu.hw7.Task3.Person;
import edu.hw7.Task3.SynchronizedPersonDataBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    SynchronizedPersonDataBase personDatabase;

    @BeforeEach
    public void createObject() {
        personDatabase = new SynchronizedPersonDataBase();
    }

    @Test
    @DisplayName("Test add method")
    public void testAdd() {
        Person person1 = new Person(1, "Alexander", "Moscow, Lenina 50", "88005553555");
        Person person2 = new Person(2, "Vasilit", "Izhevsk, Lenina 50", "88111111111");
        personDatabase.add(person1);
        personDatabase.add(person2);

        boolean response1 = personDatabase.getPeople().contains(person1);
        boolean response2 = personDatabase.getPeople().contains(person2);

        assertThat(response1).isTrue();
        assertThat(response2).isTrue();
    }

    @Test
    @DisplayName("Test delete method")
    public void testDelete() {
        Person person1 = new Person(1, "Alexander", "Moscow, Lenina 50", "88005553555");
        Person person2 = new Person(2, "Vasilit", "Izhevsk, Lenina 50", "88111111111");
        personDatabase.add(person1);
        personDatabase.add(person2);

        boolean response1 = personDatabase.getPeople().contains(person1);

        personDatabase.delete(1);

        boolean response2 = personDatabase.getPeople().contains(person1);

        assertThat(response1).isTrue();
        assertThat(response2).isFalse();
    }

    @Test
    @DisplayName("Test find name method")
    public void testFindName() {
        Person person1 = new Person(1, "Alexander", "Moscow, Lenina 50", "88005553555");
        Person person2 = new Person(2, "Vasiliy", "Izhevsk, Lenina 50", "88111111111");
        personDatabase.add(person1);
        personDatabase.add(person2);

        Person response = personDatabase.findByName("Alexander");

        assertThat(response).isEqualTo(person1);
    }

    @Test
    @DisplayName("Test find address method")
    public void testFindAddress() {
        Person person1 = new Person(1, "Alexander", "Moscow, Lenina 50", "88005553555");
        Person person2 = new Person(2, "Vasiliy", "Izhevsk, Lenina 50", "88111111111");
        personDatabase.add(person1);
        personDatabase.add(person2);

        Person response = personDatabase.findByAddress("Izhevsk, Lenina 50");

        assertThat(response).isEqualTo(person2);
    }

    @Test
    @DisplayName("Test find phone method")
    public void testFindPhone() {
        Person person1 = new Person(1, "Alexander", "Moscow, Lenina 50", "88005553555");
        Person person2 = new Person(2, "Vasiliy", "Izhevsk, Lenina 50", "88111111111");
        personDatabase.add(person1);
        personDatabase.add(person2);

        Person response = personDatabase.findByPhone("88005553555");

        assertThat(response).isEqualTo(person1);
    }
}
