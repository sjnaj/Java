
/*
 * @Author: fengsc
 * @Date: 2022-02-26 22:34:10
 * @LastEditTime: 2022-02-26 22:43:40
 */
import java.io.*;

public class AutoCloseTest {
    public static void main(String[] args) throws IOException {
        final PrintStream ps = new PrintStream(new FileOutputStream("a.txt"));
        final BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        // *可以不用显式使用final修饰，但只要不对该变量重新赋值，该变量就是有效的
        // *只要将两个资源放在try后的圆括号内即可(java9+)
        try (br; ps) {
            // 使用两个资源
            System.out.println(br.readLine());
            ps.println("C语言中文网");
        }
    }
}