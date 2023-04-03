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
    private static int getFibonacciLastDigitFast(int n){
        if (n <= 1) {
            return n;
        } else {
            int[] array = new int[n + 1];
            array[0] = 0;
            array[1] = 1;
            for(int i = 2; i < array.length; ++i) {
                array[i] = array[i - 2] + array[i - 1];
            }
            return array[n] % 10;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}