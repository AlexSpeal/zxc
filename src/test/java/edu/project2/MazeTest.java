package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MazeTest {

    @Test
    @DisplayName("Введены корректные значения лабиринта")
    void test1() {
        GeneratorMaze generator = new GeneratorMaze();
        boolean actual = false;
        boolean expected = false;
        try {
            generator.generate(5, 5);
        } catch (RuntimeException e) {
            actual = true;
        }
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Введены некорректные значения лабиринта")
    void test2() {
        GeneratorMaze generator = new GeneratorMaze();
        boolean actual = false;
        boolean expected = true;
        try {
            generator.generate(-5, 5);
        } catch (RuntimeException e) {
            actual = true;
        }
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск пути")
    void test3() {
        Maze maze;
        RenderMaze render = new RenderMaze();
        GeneratorMaze generator = new GeneratorMaze();
        SolverMaze solver = new SolverMaze();
        StringBuilder test = new StringBuilder(
            "00000"
                + "01110"
                + "01010"
                + "01010"
                + "00000");

        maze = generator.generate(5, 5, test);
        Cell start = new Cell(1, 1, Cell.Type.PASSAGE, false);
        Cell finish = new Cell(3, 3, Cell.Type.PASSAGE, false);
        StringBuilder actual = render.print(maze, solver.solve(maze, start, finish));
        StringBuilder expected = new StringBuilder("""
            [=][=][=][=][=]
            [=]\u001B[31m * \u001B[0m\u001B[31m * \u001B[0m\u001B[31m * \u001B[0m[=]
            [=]   [=]\u001B[31m * \u001B[0m[=]
            [=]   [=]\u001B[31m * \u001B[0m[=]
            [=][=][=][=][=]
            """);
        assertTrue(actual.toString().contentEquals(expected));
    }

    @Test
    @DisplayName("Вывод лабиринта")
    void test4() {
        Maze maze;
        GeneratorMaze generator = new GeneratorMaze();
        RenderMaze render = new RenderMaze();
        StringBuilder test = new StringBuilder(
            "00000"
                + "01110"
                + "01010"
                + "01010"
                + "00000");

        maze = generator.generate(5, 5, test);
        StringBuilder actual = render.print(maze);
        StringBuilder expected = new StringBuilder(
            """
                [=][=][=][=][=]
                [=]         [=]
                [=]   [=]   [=]
                [=]   [=]   [=]
                [=][=][=][=][=]
                """);
        assertTrue(actual.toString().contentEquals(expected));
    }

}
