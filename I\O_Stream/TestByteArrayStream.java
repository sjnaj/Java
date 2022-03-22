/*
 * @Author: fengsc
 * @Date: 2022-02-27 23:32:10
 * @LastEditTime: 2022-03-06 11:35:27
 */
import java.io.*;
public class TestByteArrayStream {

    public static void main(String[] args) {
        byte[] b = new byte[] { 1, -1, 25, -22, -5, 23 }; // 创建数组
        ByteArrayInputStream bais = new ByteArrayInputStream(b, 0, 6); // 创建字节数组输入流
        int i = bais.read(); // 从输入流中读取下一个字节，并转换成int型数据
        while (i != -1) { // 如果不返回-1，则表示没有到输入流的末尾
            System.out.println("原值=" + (byte) i + " \t\t\t转换为int类型=" + i);//!每四个字符算一组，制表符显示的时候只会填充满这一组，因此只要 \t 所属那组字符有不能被4整除的字符长度，\t 显示的长度也会不一样。
            i = bais.read(); // 读取下一个
        }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(b, 0, 6); // 将字节数组中的元素写到输出流中
            System.out.println("数组中一共包含：" + baos.size() + "字节"); // 输出缓冲区中的字节数
            byte[] newByteArray = baos.toByteArray(); // 将输出流中的当前内容转换成字节数组
            System.out.println(java.util.Arrays.toString(newByteArray)); // 输出数组中的内容
    }

}
