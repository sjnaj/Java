/*
 * @Author: fengsc
 * @Date: 2022-02-27 19:08:31
 * @LastEditTime: 2022-02-27 19:12:21
 */

/*
 * @Author: fengsc
 * @Date: 2022-02-27 18:16:21
 * @LastEditTime: 2022-02-27 19:07:35
 */
import java.io.*;

public class DirTest {

    public static void main(String[] args) throws Exception {
        String path = "/home/fengsc/Desktop/Java/I\\O_Stream/testDir"; // 指定目录位置
        File f = new File(path); // 创建File对象
        if (f.exists()) {
            f.delete();
        }
        f.mkdir(); // 创建目录
        File text;
        text = new File(f.getAbsolutePath() + "/test1.txt");
        text.createNewFile();
        text = new File(f.getAbsolutePath() + "/test2.txt");
        text.createNewFile();
        text = new File(f.getAbsolutePath() + "/test3.txt");
        text.createNewFile();

        //String[] fileList = f.list();
        String[] fileList=f.list(new Filter());
        for (int i = 0; i < fileList.length; i++) { // 遍历返回的字符数组
            System.out.print(fileList[i] + "\t\t");
            System.out.print((new File(fileList[i])).isFile() ? "文件" + "\t\t" : "文件夹" + "\t\t");
            System.out.println((new File(fileList[i])).length() + "字节");
        }

    }
}

class Filter implements FilenameFilter {
    // 实现 FilenameFilter 接口
    @Override
    public boolean accept(File dir, String name) {
        // 指定允许的文件类型
        return name.endsWith(".sys") || name.endsWith(".txt") || name.endsWith(".bak");
    }
}