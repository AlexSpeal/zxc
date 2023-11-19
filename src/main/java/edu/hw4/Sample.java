package edu.hw4;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("uncommentedmain")
public class Sample {
    protected final List<List<Animal>> allUserList;
    protected final List<Animal> userList = Arrays.asList(
        new Animal("Барсик", Animal.Type.CAT, Animal.Sex.M, 10, 20, 5, true),
        new Animal("Бобик", Animal.Type.DOG, Animal.Sex.M, 7, 40, 10, true),
        new Animal("Соловей", Animal.Type.BIRD, Animal.Sex.F, 2, 10, 1, false),
        new Animal("Адун", Animal.Type.FISH, Animal.Sex.F, 3, 5, 1, false),
        new Animal("Многоногич", Animal.Type.SPIDER, Animal.Sex.M, 77, 20, 2, true),
        new Animal("Мурзик", Animal.Type.CAT, Animal.Sex.M, 18, 170, 60, true),
        new Animal("Собакен", Animal.Type.DOG, Animal.Sex.M, 10, 50, 6, true),
        new Animal("Павук", Animal.Type.SPIDER, Animal.Sex.F, 7, 20, 3, true)

    );

    protected final List<Animal> userList2 = Arrays.asList(
        new Animal("Кошкинс", Animal.Type.CAT, Animal.Sex.F, 101, 23, 3, true),
        new Animal("Собачкинс", Animal.Type.DOG, Animal.Sex.F, 73, 30, 16, true),
        new Animal("Птичкинс", Animal.Type.BIRD, Animal.Sex.M, 22, 50, 5, false),
        new Animal("Воднич", Animal.Type.FISH, Animal.Sex.M, 5, 25, 2, false),
        new Animal("Паукич", Animal.Type.SPIDER, Animal.Sex.F, 3, 10, 3, true),
        new Animal("Мяукич", Animal.Type.CAT, Animal.Sex.F, 1, 10, 67, true),
        new Animal("Ауфкинс", Animal.Type.DOG, Animal.Sex.F, 15, 40, 9, true)
    );

    protected final List<Animal> brokenList = Arrays.asList(
        new Animal("", Animal.Type.CAT, Animal.Sex.F, 101, 23, 3, true),
        new Animal("Котофей", Animal.Type.DOG, Animal.Sex.F, 73, 30, 16, true),
        new Animal("Бубылдыч", null, Animal.Sex.M, -22, 50, 5, false),
        new Animal("Рыбыч", Animal.Type.FISH, Animal.Sex.F, 5, 25, 2, false),
        new Animal("Па и ук", Animal.Type.SPIDER, Animal.Sex.F, 10, 10, 3, true),
        new Animal("Кооот", Animal.Type.CAT, Animal.Sex.F, 1, 10, 67, true),
        new Animal("Догич", Animal.Type.DOG, Animal.Sex.F, 15, 40, 9, true)
    );

    protected final List<Animal> nullList = List.of();

    protected Sample() {
        allUserList = Arrays.asList(userList, userList2);
    }

    public static void main(String[] args) {
    }
}
