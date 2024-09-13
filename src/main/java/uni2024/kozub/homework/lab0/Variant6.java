package uni2024.kozub.homework.lab0;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.stream.IntStream;


public class Variant6 {

    private static final Logger logger = LogManager.getLogger(Variant6.class);
    /**
     *
     * @param k is a two-digit number
     * @return array: The first number is tens, the second is units
     */

    public int[] integerNumbersTask(int k) {
        return new int[]{k / 10, k % 10};
    }

    /**
     *
     * @return true, if A<B<C
     */
    public boolean booleanTask(int A, int B, int C) {
        return B < C && B > A;
    }


    /**
     *
     * @param a and b are integer numbers
     * @return max of a and b
     */
    public int ifTask(int a, int b) {
        return a > b ? a : b;
    }


    /**
     *
     * @param num - option
     * @param len - length
     * @return length in another dimension type
     */
    public double switchTask(int num, double len) {
        return switch (num) {
            case 1 -> len / 10;
            case 2 -> len * 1000;
            case 3 -> len;
            case 4 -> len / 1000;
            case 5 -> len / 100;
            default -> throw new IllegalArgumentException("Wrong num: " + num);
        };
    }


    /**
     *
     * @param n is a price for 1 kg
     * @return array of prices for 1.2, 1.4 ... 2.0 kg
     */
    public double[] forTask(double n) {
        assert n > 0: "Argument should be more than zero";
        double[] prices = new double[6];

        int index = 0;
        for (double i = 1.0; i <= 2; i += 0.2) {
            double price = Math.round(n * i * 100.0) / 100.0;
            prices[index++] = price;
        }
        return prices;
    }

    /**
     *
     * @param n - number
     * @return Double factorial of n
     */

    public double whileTask(int n) {
        assert n > 0 : "Argument should be more than zero";
        double res = n;
        int k = 1;

        while (n > 2) {
            n = n - k * 2;
            res *= n;
        }

        return res;
    }


    /**
     *
     * @param n - array length, a - first value in array, b - second value in array
     * @return array where each value is a sum of all previous
     *
     *
     */

    public int[] arrayTask(int n, int a, int b) {
        assert n > 2: "Argument 'n' should be more than two";
        int[] arr = new int[n];
        arr[0] = a;
        arr[1] = b;
        for (int i = 2; i < n; i++) {
            arr[i] = Arrays.stream(Arrays.copyOfRange(arr, 0, n)).sum();
        }
        return arr;
    }

    /**
     *
     * @param m and n size of our matrix
     * @param multiplier - multiplier
     * @param arr - our initial array
     * @return transformed matrix where the element of each row is multiplied by a factor
     */
    public int[][]  twoDimensionArrayTask(int m, int n, int multiplier, int[]arr) {
        int[][] matrix = new int[m][n];
        matrix[0] = arr;
        IntStream.range(1, m).forEach(i ->
                matrix[i] = IntStream.range(0, n)
                        .map(j -> matrix[i - 1][j] * multiplier)
                        .toArray()
        );
        return matrix;
    }

    public static void main(String... strings) {
        Variant6 var6 = new Variant6();
        System.out.println("Start of zero lab");
        System.out.println(Arrays.toString(var6.integerNumbersTask(57)));
        System.out.println(var6.booleanTask(1, 2, 3));
        System.out.println(var6.ifTask(9, 6));
        try {
            System.out.println(var6.switchTask(5, 1000));
        } catch (IllegalArgumentException e) {
            logger.error("Error in switchTask: ", e);
        }
        try {
            System.out.println(Arrays.toString(var6.forTask(-5)));
        } catch (AssertionError e) {
            logger.error("Error in forTask: ", e);
        }
        try {
            System.out.println(var6.whileTask(4));
        } catch (AssertionError e) {
            logger.error("Error in whileTask: ", e);
        }
        System.out.println(Arrays.toString(var6.arrayTask(6, 1, 2)));
        int[][] matrix = var6.twoDimensionArrayTask(4, 4, 2, new int[]{1, 2, 3, 4});
        for (int[] current : matrix) {
            System.out.println(Arrays.toString(current));
        }
        System.out.println("Done!!!");
    }

}

