/**
 * @Author: fengsc
 * @Date: 2022-03-21 19:04:05
 * @LastEditTime: 2022-03-23 13:43:17
 * @Description: Do not edit
 */
import java.util.Scanner;
public class Shift {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int n = input.nextInt();
            int shift = input.nextInt();
            int[] nums = new int[n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = input.nextInt();
                if (i >= shift) {
                    cnt++;
                    if (cnt == n) {
                        System.out.println(nums[i]);

                        return;
                    }
                    System.out.print(nums[i] + " ");

                }

            }
            for (int i = 0; i < shift; i++) {
                cnt++;
                if (cnt == n) {
                    System.out.println(nums[i]);
                    return;
                }
                System.out.print(nums[i] + " ");

            }
        }

    }

}