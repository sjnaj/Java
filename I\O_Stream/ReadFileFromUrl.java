
/*
 * @Author: fengsc
 * @Date: 2022-02-27 20:44:14
 * @LastEditTime: 2022-03-01 02:16:25
 */
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class ReadFileFromUrl {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter a url:");
        String urlString = new Scanner(System.in).next();
        // urlString=getRedirectUrl(urlString);//*获取重定向网址
        System.out.println(urlString);
        try {
            URL url = new URL(urlString);
            int count = 0;
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                String line = input.nextLine();
                System.out.print(line);
                count += line.length();
            }
            System.out.println();
            System.out.println("The file size is " + count + " characters");
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        } catch (IOException e) {
            System.out.println("I/O Errors: no such file");
        }

    }

    private static String getRedirectUrl(String path) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(path)
                .openConnection();
        conn.setInstanceFollowRedirects(false);
        conn.setConnectTimeout(5000);
        return conn.getHeaderField("Location");
    }

}
