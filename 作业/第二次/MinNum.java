
/*
 * @Author: fengsc
 * @Date: 2022-03-21 18:56:12
 * @LastEditTime: 2022-03-21 19:02:22
 */
import java.util.Scanner;
import java.util.Arrays;
public class MinNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < (n + 1) / 2; i++) {
            sum += (nums[i] + 1) / 2;
        }
        System.out.println(sum);
        input.close();

    }

}