
/*
 * @Author: fengsc
 * @Date: 2022-02-22 20:59:57
 * @LastEditTime: 2022-02-22 23:30:08
 */
import java.io.IOException;

public class system {

    // *System 类位于 java.lang 包，代表当前 Java 程序的运行平台，系统级的很多属性和控制方法都放置在该类的内部。由于该类的构造方法是
    // private 的，所以无法创建该类的对象，也就是无法实例化该类。

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("请输入字符，按回车键结束输入:");
        int c;
        try {
            do {
                // *读取汉字方法
                // InputStreamReader in = new InputStreamReader(System.in, "GB2312");
                // c = in.read();
                c = System.in.read();// *读取一个Byte以int形式返回
                System.out.print((char) c); // 输出字符
            } while (c != (System.getProperty("os.name").equals("Linux") ? '\n' : '\r'));// 判断输入的字符是不是回车
            // *Linux中\n表示回车+换行；
            // *Windows中\r\n表示回车+换行。
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            System.err.println();
        }

        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("程序执行时间" + (double) time / 1000 + "秒");

        char[] srcArray = { 'A', 'B', 'C', 'D' };
        char[] destArray = { 'E', 'F', 'G', 'H' };
        System.arraycopy(srcArray, 1, destArray, 1, 2);
        System.gc();// *垃圾回收
       // System.exit(0);
        String jversion = System.getProperty("java.version");
        String oName = System.getProperty("os.name");
        String user = System.getProperty("user.name");
        System.out.println("Java 运行时环境版本：" + jversion);
        System.out.println("当前操作系统是：" + oName);
        System.out.println("当前用户是：" + user);

    }

}