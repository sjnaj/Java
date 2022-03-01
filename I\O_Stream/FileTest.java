
/*
 * @Author: fengsc
 * @Date: 2022-02-27 17:07:56
 * @LastEditTime: 2022-02-27 18:15:22
 */
import java.io.*;
import java.nio.*;
import java.util.Date;

public class FileTest {

    public static void main(String[] args) throws IOException {
        String path = "/home/fengsc/Desktop/Java/I\\O_Stream"; // 指定文件所在的目录
        File f = new File(path, "Basic.md"); // 建立File变量,并设定由f变量引用
        System.out.println(f.getAbsolutePath() + "文件信息如下：");
        System.out.println("============================================");
        System.out.println("文件长度：" + f.length() + "字节");
        System.out.println("文件或者目录：" + (f.isFile() ? "是文件" : "不是文件"));
        System.out.println("文件或者目录：" + (f.isDirectory() ? "是目录" : "不是目录"));
        System.out.println("是否可读：" + (f.canRead() ? "可读取" : "不可读取"));
        System.out.println("是否可写：" + (f.canWrite() ? "可写入" : "不可写入"));
        System.out.println("是否隐藏：" + (f.isHidden() ? "是隐藏文件" : "不是隐藏文件"));
        System.out.println("最后修改日期：" + new Date(f.lastModified()));
        System.out.println("文件名称：" + f.getName());
        System.out.println("文件路径：" + f.getPath());
        System.out.println("绝对路径：" + f.getAbsolutePath());

        {
            f = new File(path, "testFile.txt");
            if (f.exists()) {
                f.delete();
            }     
                f.createNewFile();//!需要强制进行异常处理,直接处理或在函数处声明异常
        }
    }

}
