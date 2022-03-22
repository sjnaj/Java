
/*
 * @Author: fengsc
 * @Date: 2022-03-14 20:31:05
 * @LastEditTime: 2022-03-15 21:58:14
 */
import java.util.Scanner;

public class Points24 {
    public static void compute(int ans, int index) {
        if (res || index == 5)// 触底或找到组合即返回
            return;
        // DFS三叉树
        if (ans == 24)
            res = true;
        compute(ans, index + 1);// 不选

        if ((ans += nums[index]) == 24)// 选正值
            res = true;
        compute(ans, index + 1);// 向下方遍历
        if ((ans -= 2 * nums[index]) == 24) // 选负值
            res = true;
        compute(ans, index + 1);// 向下方遍历
    }

    private static int[] nums = new int[5];
    private static boolean res = false;

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in);) {
            int count = input.nextInt();
            int i;
            while (count-- != 0) {

                for (i = 0; i < 5; i++) {
                    nums[i] = input.nextInt();
                    System.out.print(nums[i]+" ");
                }
                compute(0, 0);
            
                System.out.println(res ? "YES" : "NO");
                res = false;
            }

        }

    }
}