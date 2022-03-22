
/*
 * @Author: fengsc
 * @Date: 2022-03-14 20:01:33
 * @LastEditTime: 2022-03-14 20:26:48
 */
import java.util.Scanner;

public class PrimeJudge {
    public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        if (num == 2)
            return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in);) {
            int lineCount = input.nextInt();
            int num;
            int count = 0;
            while (lineCount-- != 0) {
                while ((num = input.nextInt()) != -1)
                    if (isPrime(num))
                        count++;
                System.out.println(count);
                count = 0;

            }

        }
    }
}
