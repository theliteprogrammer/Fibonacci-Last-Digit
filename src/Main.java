import javax.swing.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    /**
     *
     * @param n - The last term of a fibonacci sequence
     * @return
     */
    private static BigInteger getFibonacciLastDigitFast(int n){
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        BigInteger[] array = new BigInteger[n + 1];
        array[0] = BigInteger.valueOf(0);
        array[1] = BigInteger.valueOf(1);
        for(int i = 2; i < array.length; i++) {
            array[i] = array[i - 1].add(array[i - 2]);
        }
        return array[n].mod(BigInteger.valueOf(10));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger c = getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}