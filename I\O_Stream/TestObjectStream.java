
/*
 * @Author: fengsc
 * @Date: 2022-02-28 12:41:58
 * @LastEditTime: 2022-02-28 13:41:34
 */
import java.io.*;

public class TestObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("/home/fengsc/Desktop/Java/I\\O_Stream/temp.dat"));) {
            output.writeUTF("Johng");
            output.writeDouble(85.5);
            output.writeObject(new java.util.Date());
        }
        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("/home/fengsc/Desktop/Java/I\\O_Stream/temp.dat"));) {

            String name = input.readUTF();
            double score = input.readDouble();
            java.util.Date date = (java.util.Date) input.readObject();
            System.out.println(name + " " + score + " " + date);

        }
    }

}
