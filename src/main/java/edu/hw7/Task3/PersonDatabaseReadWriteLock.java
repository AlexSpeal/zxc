package edu.hw7.Task3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("MagicNumber")
public class PersonDatabaseReadWriteLock implements PersonDatabase {
    private static final ReadWriteLock LOCK = new ReentrantReadWriteLock();
    private static final Map<Integer, Person> ID_MAP = new HashMap<>();
    private static final Map<String, Person> NAME_MAP = new HashMap<>();
    private static final Map<String, Person> ADDRESS_MAP = new HashMap<>();
    private static final Map<String, Person> PHONE_MAP = new HashMap<>();

    public int size() {
        return ID_MAP.size();
    }

    public void add(Person person) {
        try {
            if (LOCK.writeLock().tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    ID_MAP.put(person.id(), person);
                    if (person.name() != null) {
                        NAME_MAP.put(person.name(), person);
                    }
                    if (person.address() != null) {
                        ADDRESS_MAP.put(person.address(), person);
                    }
                    if (person.phoneNumber() != null) {
                        PHONE_MAP.put(person.phoneNumber(), person);
                    }
                } finally {
                    LOCK.writeLock().unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try {
            if (LOCK.writeLock().tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    if (ID_MAP.containsKey(id)) {
                        Person person = ID_MAP.remove(id);
                        NAME_MAP.remove(person.name());
                        ADDRESS_MAP.remove(person.address());
                        PHONE_MAP.remove(person.phoneNumber());
                    }
                } finally {
                    LOCK.writeLock().unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable Person findByName(String name) {
        try {
            if (LOCK.readLock().tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    if (NAME_MAP.containsKey(name)) {
                        Person person = NAME_MAP.get(name);
                        if (person.address() != null && person.phoneNumber() != null) {
                            return NAME_MAP.get(name);
                        }
                    }
                } finally {
                    LOCK.readLock().unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        return null;
    }

    public @Nullable Person findByAddress(String address) {
        try {
            if (LOCK.readLock().tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    if (ADDRESS_MAP.containsKey(address)
                        && ADDRESS_MAP.get(address).phoneNumber() != null
                        && ADDRESS_MAP.get(address).name() != null) {
                        return ADDRESS_MAP.get(address);
                    }
                } finally {
                    LOCK.readLock().unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        return null;
    }

    public @Nullable Person findByPhone(String phone) {
        try {
            if (LOCK.readLock().tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    if (PHONE_MAP.containsKey(phone)
                        && PHONE_MAP.get(phone).name() != null
                        && PHONE_MAP.get(phone).address() != null) {
                        return PHONE_MAP.get(phone);
                    }
                } finally {
                    LOCK.readLock().unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
