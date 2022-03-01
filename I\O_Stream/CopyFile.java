
/*
 * @Author: fengsc
 * @Date: 2022-02-28 09:24:53
 * @LastEditTime: 2022-02-28 12:28:25
 */
import java.io.*;

public class CopyFile {
    /**
     * Main method
     * 
     * @param args[0] for sourcefile
     * @param args[1] for targetfile
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java CopyFile sourceFile targetfile");
            System.exit(1);
        }

        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        File targetFile = new File(args[1]);
        if (!targetFile.exists()) {
            System.out.println("Target file " + args[1] + " does not exist");
            System.exit(3);
        }

        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));) {
            int r;
            int numberOfBytes = 0;
            while ((r = input.read()) != -1) {
                output.write((byte) r);//*r转回byte
                numberOfBytes++;
            }

            System.out.println(numberOfBytes+" bytes copied");

        }

    }

}