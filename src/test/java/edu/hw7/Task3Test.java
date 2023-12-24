package edu.hw7;

import edu.hw7.Task3.Person;
import edu.hw7.Task3.SynchronizedPersonDataBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        Person person1 = new Person(1, "Alexander", "Moscow", "+1111");
        personDatabase.add(person1);

        boolean response1 = personDatabase.getNames().containsKey("Alexander");
        boolean response2 = personDatabase.getAddresses().containsKey("Moscow");
        boolean response3 = personDatabase.getPhones().containsKey("+1111");
        boolean response4 = personDatabase.getIds().containsKey(1);

        assertThat(response1).isTrue();
        assertThat(response2).isTrue();
        assertThat(response3).isTrue();
        assertThat(response4).isTrue();
    }
    @Test
    @DisplayName("Test delete method")
    public void testDelete() {
        Person person1 = new Person(1, "Alexander", "Moscow", "+1111");
        personDatabase.add(person1);
        personDatabase.delete(1);

        boolean response1 = personDatabase.getNames().containsKey("Alexander");
        boolean response2 = personDatabase.getAddresses().containsKey("Moscow");
        boolean response3 = personDatabase.getPhones().containsKey("+1111");
        boolean response4 = personDatabase.getIds().containsKey(1);

        assertThat(response1).isFalse();
        assertThat(response2).isFalse();
        assertThat(response3).isFalse();
        assertThat(response4).isFalse();
    }
    @Test
    @DisplayName("Test find by name method")
    public void testFindByName() {
        Person person1 = new Person(1, "Alexander", "Moscow", "+1111");
        personDatabase.add(person1);

        Person response = personDatabase.findByName("Alexander").get(0);

        assertThat(response).isEqualTo(person1);
    }
    @Test
    @DisplayName("Test find by address method")
    public void testFindByAddress() {
        Person person1 = new Person(1, "Alexander", "Moscow", "+1111");
        personDatabase.add(person1);

        Person response = personDatabase.findByAddress("Moscow").get(0);

        assertThat(response).isEqualTo(person1);
    }
    @Test
    @DisplayName("Test find by phone method")
    public void testFindByPhone() {
        Person person1 = new Person(1, "Alexander", "Moscow", "+1111");
        personDatabase.add(person1);

        Person response = personDatabase.findByPhone("+1111").get(0);

        assertThat(response).isEqualTo(person1);
    }
    @Test
    @DisplayName("Test synchronization")
    public void testSynchronization() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Person person1 = new Person(1, "Alexander", "Moscow", "+1111");
        executorService.execute(() -> personDatabase.add(person1));
        Thread.sleep(2000);
        List<Person> names = executorService.submit(() -> personDatabase.findByName("Alexander")).get();
        List<Person> addresses = executorService.submit(() -> personDatabase.findByAddress("Moscow")).get();
        Thread.sleep(500);
        List<Person> phones = executorService.submit(() -> personDatabase.findByPhone("+1111")).get();
        executorService.shutdown();

        assertThat(names).contains(person1);
        assertThat(addresses).contains(person1);
        assertThat(phones).contains(person1);
    }
}
