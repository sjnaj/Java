
/*
 * @Author: fengsc
 * @Date: 2022-03-14 19:41:41
 * @LastEditTime: 2022-03-14 19:59:48
 */
import java.util.Scanner;

public class GetTriangleArea {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in);) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            if (a + b > c && b + c > a && c + a > b) {
                double p = (a + b + c) / 2.0;
                System.out.printf("%.3f%n", Math.sqrt(p * (p - a) * (p - b) * (p - c)));//!%n适应不同平台
            } else
                System.out.println("The edges cannot make up of a triangle.");

        }
    }
}