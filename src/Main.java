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
    private static long getFibonacciLastDigitFast(int n){
        if (n <= 1) {
            return n;
        }
        int previousLastDigit = 0;
        int currentLastDigit = 1;
        for (int i = 2; i <= n; i++) {
            int nextLastDigit = (previousLastDigit + currentLastDigit) % 10;
            previousLastDigit = currentLastDigit;
            currentLastDigit = nextLastDigit;
        }
        return currentLastDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long c = getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}