package edu.hw7.Task3;

import java.util.List;
import org.jetbrains.annotations.Nullable;

public interface PersonDatabase {
    void add(Person person);

    void delete(int id);


    @Nullable List<Person> findByName(String name);

    @Nullable List<Person> findByAddress(String address);

    @Nullable List<Person> findByPhone(String phone);
}
