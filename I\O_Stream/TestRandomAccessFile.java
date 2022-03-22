
/*
 * @Author: fengsc
 * @Date: 2022-03-07 09:17:52
 * @LastEditTime: 2022-03-07 09:34:59
 */
import java.io.*;

public class TestRandomAccessFile {

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile("/home/fengsc/Desktop/Java/I\\O_Stream/temp.dat", "rw")) {
            raf.setLength(0);
            System.out.println(raf.getFilePointer());
            for (int i = 0; i < 200; i++) {
                raf.writeInt(i);
            }

            

            System.out.println("Current file length: " + raf.length());

            raf.seek(0);
            System.out.println("The first number is :" + raf.readInt());

            raf.seek(1l * 4);//使用L不警告
            System.out.println("The second number is :" + raf.readInt());

            raf.seek(9l * 4);
            System.out.println("The tenth number is :" + raf.readInt());

            raf.writeInt(555);
            raf.seek(raf.length());

            
            
            
        }

    }

}
