package edu.hw7.Task3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.Nullable;

public class LockedPersonDataBase implements PersonDatabase {
    private List<Person> people = new CopyOnWriteArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        Person person1 = findById(person.id());
        Person person2 = findByName(person.name());
        Person person3 = findByAddress(person.address());
        Person person4 = findByPhone(person.phoneNumber());
        if ((person1 == null || person2 == null || person3 == null || person4 == null)
            || !(person1.equals(person2) && person2.equals(person3) && person3.equals(person4))) {
            people.add(person);
        }
        lock.writeLock().unlock();
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        Person person = findById(id);
        if (person != null) {
            people.remove(person);
        }
        lock.writeLock().unlock();
    }

    private @Nullable Person findById(int id) {
        lock.readLock().lock();
        try {
            return people.stream().filter(person -> person.id() == id).findFirst().orElse(null);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public @Nullable Person findByName(String name) {
        lock.readLock().lock();
        try {
            return people.stream().filter(person -> person.name().equals(name)).findFirst().orElse(null);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public @Nullable Person findByAddress(String address) {
        lock.readLock().lock();
        try {
            return people.stream().filter(person -> person.address().equals(address)).findFirst().orElse(null);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public @Nullable Person findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return people.stream().filter(person -> person.phoneNumber().equals(phone)).findFirst().orElse(null);
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Person> getPeople() {
        return people;
    }
}
