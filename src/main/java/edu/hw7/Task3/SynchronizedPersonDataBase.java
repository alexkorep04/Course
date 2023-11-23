package edu.hw7.Task3;

import java.util.List;
import org.jetbrains.annotations.Nullable;

public class SynchronizedPersonDataBase extends ParticularPersonDatabase  {

    @Override
    public synchronized void add(Person person) {
        super.add(person);
    }

    @Override
    public synchronized void delete(int id) {
        super.delete(id);
    }

    @Override
    public @Nullable synchronized List<Person> findByName(String name) {
        return super.findByName(name);
    }

    @Override
    public @Nullable synchronized List<Person> findByAddress(String address) {
        return super.findByAddress(address);
    }

    @Override
    public @Nullable synchronized List<Person> findByPhone(String phone) {
        return super.findByPhone(phone);
    }
}
