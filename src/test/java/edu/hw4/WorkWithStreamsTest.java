package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WorkWithStreamsTest {

    @Test
    @DisplayName("Животные отсортированы от маленького к большому")
    void test1() {
        // Given
        Sample sample = new Sample();
        boolean isRightOrderHeight = true;

        // When
        List<Animal> list = WorkWithStreams.task1(sample);
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i).height() > list.get(i + 1).height()) {
                isRightOrderHeight = false;
                break;
            }
        }

        // Then
        assertTrue(isRightOrderHeight);
    }

    @Test
    @DisplayName("Животные отсортированы от тяжелого к легкому")
    void test2() {
        Sample sample = new Sample();
        boolean isReverseOrderWeight = true;
        int k = 4;

        List<Animal> list = WorkWithStreams.task2(sample, k);
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i).weight() < list.get(i + 1).weight()) {
                isReverseOrderWeight = false;
                break;
            }
        }

        assertTrue(isReverseOrderWeight);
    }

    @Test
    @DisplayName("В списке k штук животных")
    void test23() {
        Sample sample = new Sample();
        int k = 4;

        List<Animal> list = WorkWithStreams.task2(sample, k);

        assertEquals(k, list.size());
    }

    @Test
    @DisplayName("Сколько животных каждого вида")
    void test3() {
        Sample sample = new Sample();

        Map<Animal.Type, Long> map = WorkWithStreams.task3(sample);
        Map<Animal.Type, Long> result = new HashMap<>();
        result.put(Animal.Type.CAT, 2L);
        result.put(Animal.Type.DOG, 2L);
        result.put(Animal.Type.SPIDER, 2L);
        result.put(Animal.Type.FISH, 1L);
        result.put(Animal.Type.BIRD, 1L);

        assertEquals(result, map);
    }

    @Test
    @DisplayName("Животное с самым длинным именем")
    void test4() {
        Sample sample = new Sample();
        Animal maxLengthName = sample.userList.get(0);

        Animal animal = WorkWithStreams.task4(sample);
        for (int i = 1; i < sample.userList.size(); ++i) {
            if (sample.userList.get(i).name().length() > maxLengthName.name().length()) {
                maxLengthName = sample.userList.get(i);
            }
        }

        assertEquals(maxLengthName, animal);
    }

    @Test
    @DisplayName("Кого больше: самцов или самок")
    void test5() {
        Sample sample = new Sample();
        Animal.Sex theMostSex;
        int countOfMale = 0;
        int countOfFemale = 0;

        Animal.Sex sex = WorkWithStreams.task5(sample);
        for (var it : sample.userList) {
            if (it.sex().equals(Animal.Sex.M)) {
                countOfMale++;
            }
            if (it.sex().equals(Animal.Sex.F)) {
                countOfFemale++;
            }
        }
        theMostSex = countOfMale < countOfFemale ? Animal.Sex.F
            : countOfMale > countOfFemale ? Animal.Sex.M : null;

        assertEquals(theMostSex, sex);
    }

    @Test
    @DisplayName("Самое тяжелое животное каждого вида")
    void test6() {
        Sample sample = new Sample();
        boolean isTheMostWeight = true;

        Map<Animal.Type, Animal> map = WorkWithStreams.task6(sample);
        for (var it : map.entrySet()) {
            for (int i = 0; i < sample.userList.size(); ++i) {
                if (it.getValue().type().equals(sample.userList.get(i).type())
                    && it.getValue().weight() < sample.userList.get(i).weight()) {
                    isTheMostWeight = false;
                    break;
                }
            }
        }

        assertTrue(isTheMostWeight);
    }

    @Test
    @DisplayName("Результатом метода является k-е самое старое животное")
    void test7() {
        Sample sample = new Sample();
        int k = 4;

        Animal animal = WorkWithStreams.task7(sample, k);
        List<Animal> list = sample.userList.stream()
            .sorted(Comparator.comparing(Animal::age).reversed())
            .toList();

        assertEquals(list.get(k - 1), animal);
    }

    @Test
    @DisplayName("Самое тяжелое животное ниже k см")
    void test8() {
        Sample sample = new Sample();
        Animal maxWeightLessThanK = new Animal(null, null, null, 0, 0, 0, false);
        int k = 100;

        Optional<Animal> animal = WorkWithStreams.task8(sample, k);
        for (var it : sample.userList) {
            if (it.height() < k) {
                if (it.weight() > maxWeightLessThanK.weight()) {
                    maxWeightLessThanK = it;
                }
            }
        }

        assertEquals(maxWeightLessThanK, animal.orElse(null));
    }

    @Test
    @DisplayName("Количество лап у животных в списке")
    void test9() {
        Sample sample = new Sample();
        int sumOfPaws = 0;

        Integer countPaws = WorkWithStreams.task9(sample);
        for (var it : sample.userList) {
            sumOfPaws += it.paws();
        }

        assertEquals(sumOfPaws, countPaws);
    }

    @Test
    @DisplayName("Животные, возраст которых не совпадает с количеством лап")
    void test10() {
        Sample sample = new Sample();
        List<Animal> pawsNotEqualsAgeList = new ArrayList<>();

        List<Animal> list = WorkWithStreams.task10(sample);
        for (var it : sample.userList) {
            if (it.paws() != it.age()) {
                pawsNotEqualsAgeList.add(it);
            }
        }

        assertEquals(pawsNotEqualsAgeList, list);
    }

    @Test
    @DisplayName("Животные, которые могут укусить и рост которых превышает 100 см")
    void test11() {
        Sample sample = new Sample();
        List<Animal> canBitesAndHeightMoreThan100List = new ArrayList<>();

        List<Animal> list = WorkWithStreams.task11(sample);
        for (var it : sample.userList) {
            if (it.bites() && it.height() > 100) {
                canBitesAndHeightMoreThan100List.add(it);
            }
        }

        assertEquals(canBitesAndHeightMoreThan100List, list);
    }

    @Test
    @DisplayName("Количество животных, чей вес превышает рост")
    void test12() {
        Sample sample = new Sample();
        Integer countWeightMoreThanHeight = 0;

        Integer count = WorkWithStreams.task12(sample);
        for (var it : sample.userList) {
            if (it.weight() > it.height()) {
                countWeightMoreThanHeight++;
            }
        }

        assertEquals(countWeightMoreThanHeight, count);
    }

    @Test
    @DisplayName("Животные, имена которых состоят из более чем двух слов")
    void test13() {
        Sample sample = new Sample();
        List<Animal> nameIsMoreOneWord = new ArrayList<>();

        List<Animal> list = WorkWithStreams.task13(sample);
        for (var it : sample.userList) {
            String s = it.name();
            if (s.contains(" ")
                && s.indexOf(" ") != s.length() - 1
                && s.indexOf(" ") != 0
                && !Character.toString(s.charAt(s.indexOf(" ") + 1)).equals(" ")) {
                nameIsMoreOneWord.add(it);
            }
        }

        assertEquals(nameIsMoreOneWord, list);
    }

    @Test
    @DisplayName("Есть ли собака ростом больше k в списке")
    void test14() {
        Sample sample = new Sample();
        int k = 10;
        boolean isDogAndHeightMoreThanK = false;

        Boolean flag = WorkWithStreams.task14(sample, k);
        for (var it : sample.userList) {
            if (it.type().equals(Animal.Type.DOG) && it.height() > k) {
                isDogAndHeightMoreThanK = true;
                break;
            }
        }

        assertEquals(isDogAndHeightMoreThanK, flag);
    }

    @Test
    @DisplayName("k - отрицательное")
    void test141() {
        Sample sample = new Sample();
        int k = -1;

        Boolean flag = WorkWithStreams.task14(sample, k);

        assertNull(flag);
    }

    @Test
    @DisplayName("Суммарный вес каждого вида от k до l лет")
    void test15() {
        Sample sample = new Sample();
        int k = 10;
        int l = 40;

        Map<Animal.Type, Integer> map = WorkWithStreams.task15(sample, k, l);
        Map<Animal.Type, Integer> result = new HashMap<>();
        result.put(Animal.Type.CAT, 65);
        result.put(Animal.Type.DOG, 6);
        result.put(Animal.Type.SPIDER, 0);
        result.put(Animal.Type.FISH, 0);
        result.put(Animal.Type.BIRD, 0);

        assertEquals(result, map);
    }

    @Test
    @DisplayName("Проверка, что список отсортирован по виду, затем по полу, затем по имени")
    void test16() {
        Sample sample = new Sample();
        boolean isTypeThenSexThenName = true;

        List<Animal> list = WorkWithStreams.task16(sample);
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i).type().getName().compareTo(list.get(i + 1).type().getName()) > 0
                || list.get(i).type().getName().compareTo(list.get(i + 1).type().getName()) > 0
                && list.get(i).sex().getName().compareTo(list.get(i + 1).sex().getName()) > 0
                || list.get(i).type().getName().compareTo(list.get(i + 1).type().getName()) > 0
                && list.get(i).sex().getName().compareTo(list.get(i + 1).sex().getName()) > 0
                && list.get(i).name().compareTo(list.get(i + 1).name()) > 0) {
                isTypeThenSexThenName = false;
                break;
            }
        }

        assertTrue(isTypeThenSexThenName);
    }

    @Test
    @DisplayName("Пауки кусаются чаще собак")
    void test17() {
        Sample sample = new Sample();
        boolean isSpiderBitesOftenThanDog = true;
        int countOfBitesDog = 0;
        int countOfBitesSpider = 0;

        Boolean flag = WorkWithStreams.task17(sample);
        for (var it : sample.userList) {
            if (it.type().equals(Animal.Type.DOG) && it.bites()) {
                countOfBitesDog++;
            }
            if (it.type().equals(Animal.Type.SPIDER) && it.bites()) {
                countOfBitesSpider++;
            }
        }
        if (countOfBitesDog >= countOfBitesSpider) {
            isSpiderBitesOftenThanDog = false;
        }

        assertEquals(isSpiderBitesOftenThanDog, flag);
    }

    @Test
    @DisplayName("Самая тяжелая рыба среди нескольких списков")
    void test18() {

        Sample sample = new Sample();
        Animal maxWeightLessThanK = new Animal(null, null, null, 0, 0, 0, false);

        Animal animal = WorkWithStreams.task18(sample);
        for (var it : sample.allUserList) {
            for (int i = 0; i < it.size(); ++i) {
                if (it.get(i).type().equals(Animal.Type.FISH)
                    && it.get(i).weight() > maxWeightLessThanK.weight()) {
                    maxWeightLessThanK = it.get(i);
                }
            }
        }

        assertEquals(maxWeightLessThanK, animal);
    }

    @Test
    @DisplayName("Метод возвращает непустое значение")
    void test19() {
        Sample sample = new Sample();

        Map<String, Set<ValidationError>> map = WorkWithStreams.task19(sample);

        assertNotNull(map);
    }

    @Test
    @DisplayName("Метод возвращает таблицу, значением которой является множество из ValidationError")
    void test191() {
        Sample sample = new Sample();
        StringBuilder s = new StringBuilder();

        Map<String, Set<ValidationError>> map = WorkWithStreams.task19(sample);
        for (var it : map.entrySet()) {
            if (s.isEmpty()) {
                s.append("{").append(it.getKey()).append("=").append(it.getValue().toString());
            } else {
                s.append(", ").append(it.getKey()).append("=").append(it.getValue().toString());
            }
        }
        s.append("}");

        assertEquals(s.toString(), map.toString());
    }

    @Test
    @DisplayName("Метод возвращает непустое значение")
    void test20() {
        Sample sample = new Sample();

        Map<String, String> map = WorkWithStreams.task20(sample);

        assertNotNull(map);
    }

    @Test
    @DisplayName("Метод возвращает таблицу, значением которой является одна строка")
    void test21() {
        Sample sample = new Sample();
        StringBuilder s = new StringBuilder();

        Map<String, String> map = WorkWithStreams.task20(sample);
        for (var it : map.entrySet()) {
            if (s.isEmpty()) {
                s.append("{").append(it.getKey()).append("=").append(it.getValue());
            } else {
                s.append(", ").append(it.getKey()).append("=").append(it.getValue());
            }
        }
        s.append("}");

        assertEquals(s.toString(), map.toString());
    }
}
