
/*
 * @Author: fengsc
 * @Date: 2022-03-21 19:36:42
 * @LastEditTime: 2022-03-21 22:32:33
 */
import java.util.Scanner;
import java.io.*;

public class Statistic {
    public static void main(String[] args) throws IOException {//强制检测
    
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int[] counts = new int[26];
            int s;
            while ((s = br.read()) !='\n') {
                    counts[s - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    System.out.println((char) (i + 'a') + ":" + counts[i]);
                }
            }
        }
    }
}
