package edu.hw7.Task3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.Nullable;

public class SynchronizedPersonDataBase implements PersonDatabase {
    private List<Person> people = new CopyOnWriteArrayList<>();

    @Override
    public synchronized void add(Person person) {
        Person person1 = findById(person.id());
        Person person2 = findByName(person.name());
        Person person3 = findByAddress(person.address());
        Person person4 = findByPhone(person.phoneNumber());
        if ((person1 == null || person2 == null || person3 == null || person4 == null) ||
            !(person1.equals(person2) && person2.equals(person3) && person3.equals(person4))) {
            people.add(person);
        }
    }

    @Override
    public synchronized void delete(int id) {
        Person person = findById(id);
        if (person != null) {
            people.remove(person);
        }
    }

    private synchronized @Nullable Person findById(int id) {
        return people.stream().filter(person -> person.id() == id).findFirst().orElse(null);
    }

    @Override
    public synchronized @Nullable Person findByName(String name) {
        return people.stream().filter(person -> person.name().equals(name)).findFirst().orElse(null);
    }

    @Override
    public synchronized @Nullable Person findByAddress(String address) {
        return people.stream().filter(person -> person.address().equals(address)).findFirst().orElse(null);
    }

    @Override
    public synchronized @Nullable Person findByPhone(String phone) {
        return people.stream().filter(person -> person.phoneNumber().equals(phone)).findFirst().orElse(null);
    }

    public List<Person> getPeople() {
        return people;
    }
}
