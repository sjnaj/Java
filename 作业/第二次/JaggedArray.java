
/*
 * @Author: fengsc
 * @Date: 2022-03-21 21:22:40
 * @LastEditTime: 2022-03-21 21:53:48
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public class JaggedArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] array = new int[n][];
        for (int i = 0; i < n; i++) {
            array[i] = new int[input.nextInt()];
            for (int j = 0; j < array[i].length; j++)
                array[i][j] = input.nextInt();
        }
        Arrays.sort(array,
                (int[] a, int[] b) -> (Arrays.stream(a).sum() / a.length > Arrays.stream(b).sum() / b.length) ? 1 : -1);
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < array[i].length - 1; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(array[i][j]);
        }
    }

}
