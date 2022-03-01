
/*
 * @Author: fengsc
 * @Date: 2022-02-27 23:08:39
 * @LastEditTime: 2022-02-27 23:16:18
 */
import java.io.*;

public class TestFileStream {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/fengsc/Desktop/Java/I\\O_Stream/temp.dat");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        try (FileOutputStream output = new FileOutputStream(file)) {
            for (int i = 0; i < 10; i++) {
                output.write(i);
            }
        }
        try (FileInputStream input = new FileInputStream(file)) {
            int value;
            while ((value = input.read()) != -1)
                System.out.print(value + " ");
        }

    }

}
