
/*
 * @Author: fengsc
 * @Date: 2022-02-28 09:08:16
 * @LastEditTime: 2022-02-28 09:16:38
 */
import java.io.*;

public class TestDataStream {
    public static void main(String[] args) throws IOException {
        try (DataOutputStream output = new DataOutputStream(
                new FileOutputStream("/home/fengsc/Desktop/Java/I\\O_Stream/temp.dat"))) {
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
            output.writeUTF("George");
            output.writeDouble(105.25);

        }
        try (DataInputStream input = new DataInputStream(
                new FileInputStream("/home/fengsc/Desktop/Java/I\\O_Stream/temp.dat"))) {
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());//到达文件末尾继续读取

        } catch (EOFException e) {
            System.out.println("All Data were read");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
