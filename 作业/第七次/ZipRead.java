
/**
 * @Author: fengsc
 * @Date: 2022-05-15 01:09:06
 * @LastEditTime: 2022-05-15 01:40:18
 */
import java.io.*;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.*;

public class ZipRead {
    public static void main(String[] args) throws IOException {
        try (Scanner input = new Scanner(System.in);
                ZipFile zip = new ZipFile("/home/fengsc/Downloads/ilovepdf_pages-to-jpg.zip");) {
            int n = input.nextInt() - 1;
            Enumeration<? extends ZipEntry> entries = zip.entries();
            while (entries.hasMoreElements()) {
                String name = entries.nextElement().getName();
                if (n-- == 0) {
                    System.out.println(name);
                    break;
                }
            }

        }
    }
}
