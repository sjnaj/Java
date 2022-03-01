
/*
 * @Author: fengsc
 * @Date: 2022-02-26 12:14:27
 * @LastEditTime: 2022-02-26 12:24:25
 */
import java.util.ArrayList;
import java.util.Scanner;

public class DistinctNumbers {
    public static void main(String[] args) {

        // ArrayList<int> list = new ArrayList<>()//存储的元素必须是对象
        ArrayList<Integer> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter integers (input ends with 0):");
        int value;
        do {
            value = input.nextInt();
            if (!list.contains(value) && value != 0) {
                list.add(value);
            }
        } while (value != 0);
        //java.util.Arrays.sort(array);//*普通数组排序
        java.util.Collections.sort(list);//*ArrayList排序
        for (int number : list) {
            // System.out.print(list.get(i) + " ");
            System.out.print(number + " ");
        }
        System.out.println();
    }

}
