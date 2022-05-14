
/**
 * @Author: fengsc
 * @Date: 2022-04-25 17:24:25
 * @LastEditTime: 2022-05-14 21:05:08
 */
import java.util.Scanner;
import java.util.regex.*;

public class MatchTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        while (count-- != 0) {
            String str = input.next();
            str = str.replaceAll("%", ".*");
            str = str.replaceAll("_", ".");
            System.out.println(Pattern.matches(str, input.next())?"yes":"no");
        }
        input.close();

    }

}
