
/*
 * @Author: fengsc
 * @Date: 2022-03-14 19:11:43
 * @LastEditTime: 2022-03-14 19:38:33
 */
import java.util.Scanner;

public class SimpleSum {
    public static void main(String[] args) throws IllegalArgumentException {
        try (Scanner input = new Scanner(System.in);) {
            int a = input.nextInt();
            int b = input.nextInt();
            if (a <= 0 || a >= 10000 || b <= 0 || b >= 10000)
                throw new IllegalArgumentException("0<a,b<10000");
            System.out.println(a + b);
        }
    }

}
