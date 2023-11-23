package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class ParticularPersonDatabase implements PersonDatabase {
    private final Map<Integer, Person> ids;
    private final Map<String, List<Person>> names;
    private final Map<String, List<Person>> addresses;
    private final Map<String, List<Person>> phones;

    public ParticularPersonDatabase() {
        ids = new HashMap<>();
        names = new HashMap<>();
        addresses = new HashMap<>();
        phones = new HashMap<>();
    }

    @Override
    public void add(Person person) {
        ids.put(person.id(), person);
        names.computeIfAbsent(person.name(), name -> new ArrayList<>()).add(person);
        addresses.computeIfAbsent(person.address(), address -> new ArrayList<>()).add(person);
        phones.computeIfAbsent(person.phoneNumber(), phoneNumber -> new ArrayList<>()).add(person);
    }

    @Override
    public void delete(int id) {
        Person deletedPerson = ids.remove(id);
        if (deletedPerson != null) {
            names.remove(deletedPerson.name());
            addresses.remove(deletedPerson.address());
            phones.remove(deletedPerson.phoneNumber());
        }
    }

    @Override
    public @Nullable List<Person> findByName(String name) {
        if (names.containsKey(name)) {
            return names.get(name).stream().toList();
        }
        return null;
    }

    @Override
    public @Nullable List<Person> findByAddress(String address) {
        if (addresses.containsKey(address)) {
            return addresses.get(address).stream().toList();
        }
        return null;
    }

    @Override
    public @Nullable List<Person> findByPhone(String phone) {
        if (phones.containsKey(phone)) {
            return phones.get(phone).stream().toList();
        }
        return null;
    }

    public Map<Integer, Person> getIds() {
        return ids;
    }

    public Map<String, List<Person>> getNames() {
        return names;
    }

    public Map<String, List<Person>> getAddresses() {
        return addresses;
    }

    public Map<String, List<Person>> getPhones() {
        return phones;
    }
}
