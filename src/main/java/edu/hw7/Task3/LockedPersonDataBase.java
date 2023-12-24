package edu.hw7.Task3;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.Nullable;

public class LockedPersonDataBase extends ParticularPersonDatabase {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        try {
            lock.writeLock().lock();
            super.add(person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        try {
            lock.writeLock().lock();
            super.delete(id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public @Nullable List<Person> findByName(String name) {
        try {
            lock.readLock().lock();
            return super.findByName(name);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public @Nullable List<Person> findByAddress(String address) {
        try {
            lock.readLock().lock();
            return super.findByAddress(address);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public @Nullable List<Person> findByPhone(String phone) {
        try {
            lock.readLock().lock();
            return super.findByPhone(phone);
        } finally {
            lock.readLock().unlock();
        }
    }

}
