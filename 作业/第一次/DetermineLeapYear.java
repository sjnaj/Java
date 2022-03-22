
/*
 * @Author: fengsc
 * @Date: 2022-03-14 19:26:58
 * @LastEditTime: 2022-03-14 19:39:07
 */
import java.util.Scanner;

public class DetermineLeapYear {
    public static void main(String[] args) throws IllegalArgumentException {
        try (Scanner input = new Scanner(System.in);) {
            int year = input.nextInt();
            if (year < 1900 || year > 2500)
                throw new IllegalArgumentException("1900<=year<=2500");
            System.out.println((year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? "Yes" : "No");

        }
    }

}