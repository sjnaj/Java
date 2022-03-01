
/*
 * @Author: fengsc
 * @Date: 2022-02-27 19:26:48
 * @LastEditTime: 2022-02-27 20:43:46
 */
import java.io.*;
import java.util.*;

public class ReadData {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/fengsc/Desktop/Java/I\\O_Stream/testFile.txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String firstName = input.next();
                String mi = input.next();
                String lastName = input.next();
                int score = input.nextInt();
                System.out.println(firstName + " " + mi + " " + lastName + " " + score);
            }
        }
        try (Scanner input = new Scanner("13 14")) {// *Scanner还能从字符串读取
            int sum = input.nextInt() + input.nextInt();
            System.out.println("sum is " + sum);
        }

    }

}
