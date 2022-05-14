/**
 * @Author: fengsc
 * @Date: 2022-05-15 00:50:18
 * @LastEditTime: 2022-05-15 01:06:53
 */
import java.util.Scanner;
import java.io.*;

public class BitRead {
    public static void main(String[] args) throws IOException {
        // int a;
        // boolean b = true;
        // double c, f;
        // String d;
        // DataOutputStream out = new DataOutputStream(new FileOutputStream("dict.dic"));
        // Scanner cin = new Scanner(System.in);

        // for (int i = 0; i < 5; i++) {
        // a = cin.nextInt();
        // f = Math.random();
        // if (f > 0.5)
        // b = true;
        // else
        // b = false;
        // c = cin.nextDouble();
        // d = cin.next();
        // out.writeInt(a);
        // out.writeBoolean(b);
        // out.writeDouble(c);
        // out.writeUTF(d);
        // }

        // out.close(); // Remember this!
        // cin.close();
        try (Scanner input = new Scanner(System.in);
                DataInputStream in = new DataInputStream(new FileInputStream("dict.dic"))) {
            int n = input.nextInt()-1;
            while (n-- != 0) {
                in.readInt();
                in.readBoolean();
                in.readDouble();
                in.readUTF();
            }
            System.out.println(in.readInt());
            System.out.println(in.readBoolean());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        }
    }
}
