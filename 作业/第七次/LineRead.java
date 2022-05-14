
/**
 * @Author: fengsc
 * @Date: 2022-05-15 00:01:18
 * @LastEditTime: 2022-05-15 01:23:39
 */
import java.io.*;
import java.util.Scanner;
import java.nio.file.*;

public class LineRead {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        Files.lines(Paths.get("dict.dic")).skip((in.nextInt() - 1) * 4).limit(4)
                .forEach(System.out::println);
    }

}
