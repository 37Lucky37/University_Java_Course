import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni2024.kozub.homework.lab0.Variant6;
import static org.junit.jupiter.api.Assertions.*;

public class Variant6Test {

    private Variant6 variant6;

    @BeforeEach
    void setUp() {
        variant6 = new Variant6();
    }

    @AfterEach
    void tearDown() {
        variant6 = null;
    }

    @Test
    void testIntegerNumbersTask() {
        int[] result = variant6.integerNumbersTask(57);
        assertArrayEquals(new int[]{5, 7}, result, "Число 57 повинно розбиватися на 5 і 7");
    }

    @Test
    void testBooleanTask() {
        assertTrue(variant6.booleanTask(1, 2, 3), "2 повинно бути між 1 та 3");
        assertFalse(variant6.booleanTask(3, 2, 1), "2 не може бути між 3 і 1");
    }

    @Test
    void testIfTask() {
        assertEquals(9, variant6.ifTask(9, 6), "9 більше за 6");
        assertEquals(6, variant6.ifTask(4, 6), "6 більше за 4");
    }

    @Test
    void testSwitchTask() {
        assertEquals(10.0, variant6.switchTask(5, 1000), "1 метр = 100 см");
        assertEquals(1.0, variant6.switchTask(3, 1), "Метр = метр");
        assertThrows(IllegalArgumentException.class, () -> variant6.switchTask(10, 100), "Невірний варіант");
    }

    @Test
    void testForTask() {
        double[] result = variant6.forTask(5);
        double[] expected = {5.00, 6.00, 7.00, 8.00, 9.00, 10.00};
        assertArrayEquals(expected, result, 0.01);
    }

    @Test
    void testWhileTask() {
        assertEquals(945.0, variant6.whileTask(9), "Подвійний факторіал для 9 повинен бути 945");
        assertEquals(48.0, variant6.whileTask(6), "Подвійний факторіал для 6 повинен бути 48");
    }

    @Test
    void testArrayTask() {
        int[] result = variant6.arrayTask(5, 1, 2);
        int[] expected = {1, 2, 3, 6, 12};
        assertArrayEquals(expected, result, "Сума попередніх елементів повинна бути в наступному");
    }

    @Test
    void testTwoDimensionArrayTask() {
        int[][] result = variant6.twoDimensionArrayTask(4, 4, 2, new int[]{1, 2, 3, 4});
        int[][] expected = {
                {1, 2, 3, 4},
                {2, 4, 6, 8},
                {4, 8, 12, 16},
                {8, 16, 24, 32}
        };
        assertArrayEquals(expected, result, "Кожен рядок повинен бути добутком попереднього на 2");
    }

    @Test
    void testNegativeWhileTask() {
        assertThrows(AssertionError.class, () -> variant6.whileTask(-1), "Аргумент має бути більше нуля");
    }

    @Test
    void testNegativeArrayTask() {
        assertThrows(AssertionError.class, () -> variant6.arrayTask(2, 1, 2), "Довжина масиву має бути більше двох");
    }
}
