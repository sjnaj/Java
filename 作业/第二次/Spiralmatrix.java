
/*
 * @Author: fengsc
 * @Date: 2022-03-21 21:04:41
 * @LastEditTime: 2022-03-21 21:17:04
 */
import java.util.Scanner;

public class Spiralmatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        int ele = 1;
        int i, j, k;
        matrix[0][0] = ele++;
        for (i = 1; i < n; i++) {
            for (j = 0; j <= i; j++)
                matrix[j][i] = ele++;
            for (k = i - 1; k >= 0; k--)
                matrix[j-1][k] = ele++;//注意j要减回来
        }
        for (i = 0; i <n; i++){
            for (j = 0; j < n-1; j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println(matrix[i][j]);
        }
    }

}
