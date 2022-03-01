
/*
 * @Author: fengsc
 * @Date: 2022-02-27 19:15:32
 * @LastEditTime: 2022-02-27 19:25:15
 */
import java.io.*;

public class WriteData {
    public static void main(String[] args) throws IOException {
        try (
                PrintWriter output = new PrintWriter(new File("/home/fengsc/Desktop/Java/I\\O_Stream/testFile.txt"))) {
            output.print("John T Smith ");
            output.println(90);
            output.print("Eric K Jones ");
            output.print(85);
        }
        // output.close();//*必须关闭文件才能写入,还可以用try-with-resources自动关闭

    }
}
