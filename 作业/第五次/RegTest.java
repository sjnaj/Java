
/**
 * @Author: fengsc
 * @Date: 2022-04-25 15:20:26
 * @LastEditTime: 2022-04-25 16:34:00
 */
import java.util.regex.*;
import java.util.Scanner;
public class RegTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String reg=input.next();
        String str=input.next();
        int index=reg.indexOf("*");
        Pattern pattern1 = Pattern.compile(reg.substring(0,index)+".*?"+reg.substring(index+1));//懒惰
        Pattern pattern2 = Pattern.compile(reg.substring(0,index)+".*"+reg.substring(index+1));//贪婪

        Matcher matcher1 = pattern1.matcher(str);
        Matcher matcher2 = pattern2.matcher(str);
        matcher1.find();//部分匹配
        System.out.println(matcher1.group());
        matcher2.find();
        System.out.println(matcher2.group());
        input.close();
    }
}