
/*
 * @Author: fengsc
 * @Date: 2022-02-27 23:54:27
 * @LastEditTime: 2022-02-28 00:10:13
 */
import java.io.*;

public class FileStream {
    public static void main(String[] args) throws Exception {
        File f = new File("/home/fengsc/Desktop/Java/I\\O_Stream/FileTest.java");
        try (FileInputStream fis = new FileInputStream(f)) {
            // 定义一个字节数组
            byte[] bytes = new byte[1024];
            int n = 0; // 得到实际读取到的字节数
            System.out.println(f.getAbsolutePath() + "文件内容如下：");
            // 循环读取
            while ((n = fis.read(bytes)) != -1) {
                String s = new String(bytes, 0, n); // 将数组中从下标0到n的内容给s
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        File srcFile = new File("/home/fengsc/Desktop/Java/I\\O_Stream/FileTest.java");

        File targetFile = new File("/home/fengsc/Desktop/Java/I\\O_Stream/FileTest.txt");

        try (FileInputStream fis = new FileInputStream(srcFile);
                FileOutputStream fos = new FileOutputStream(targetFile)) {
            byte[] bytes = new byte[1024]; // 每次读取1024字节
            int i = fis.read(bytes);
            while (i != -1) {
                fos.write(bytes, 0, i); // 向文件中写入内容
                i = fis.read(bytes);
            }
            System.out.println("写入结束！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
