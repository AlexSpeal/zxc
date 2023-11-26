package edu.hw7.Task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDatabaseRealizationTest {

    private static final PersonDatabaseRealization PERSON_DATABASE = new PersonDatabaseRealization();

    private final Thread thread1 = new Thread(() -> {
        PERSON_DATABASE.add(new Person(0, "Anatoliy", "Mitin", "112"));
        PERSON_DATABASE.add(new Person(1, "Pavel", "Barkoff", "456"));
        PERSON_DATABASE.add(new Person(2, null, "Z", "12312"));
    });

    private final Thread thread2 = new Thread(() -> {
        PERSON_DATABASE.add(new Person(3, "Dima", "Kireev", "43434"));
        PERSON_DATABASE.add(new Person(4, "Alexander", "Gonnyih", "1235"));
        PERSON_DATABASE.add(new Person(5, "V", null, "0"));
    });

    @BeforeEach
    void setUp() {
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Все записи добавляются")
    void test1() {
        assertEquals(6, PERSON_DATABASE.size());
    }

    @Test
    @DisplayName("Запись найдется если у неё есть все атрибуты")
    void test2() {
        assertNotNull(PERSON_DATABASE.findByName("Alexander"));
    }

    @Test
    @DisplayName("Запись не найдется если у неё есть не все атрибуты")
    void test3() {
        assertNull(PERSON_DATABASE.findByName("V"));
    }

    @Test
    @DisplayName("Запись удаляется")
    void test4() {
        PERSON_DATABASE.delete(0);

        assertEquals(5, PERSON_DATABASE.size());
    }

    @Test
    @DisplayName("При удалении несуществующей записи ничего не происходит")
    void test5() {
        PERSON_DATABASE.delete(6);

        assertEquals(6, PERSON_DATABASE.size());
    }

    @Test
    @DisplayName("При многопоточном удалении все удаляемые записи удаляются")
    void test6() {
        Thread thread1 = new Thread(() -> {
            PERSON_DATABASE.delete(0);
            PERSON_DATABASE.delete(1);
            PERSON_DATABASE.delete(2);
        });
        Thread thread2 = new Thread(() -> {
            PERSON_DATABASE.delete(3);
            PERSON_DATABASE.delete(4);
            PERSON_DATABASE.delete(5);
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertEquals(0, PERSON_DATABASE.size());
    }
}
