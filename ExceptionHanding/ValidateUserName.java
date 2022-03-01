/*
 * @Author: fengsc
 * @Date: 2022-02-26 23:15:24
 * @LastEditTime: 2022-02-26 23:19:22
 */
import java.util.Scanner;

public class ValidateUserName {
        public boolean validateUserName(String username) {
            boolean con=false;
            if (username.length() > 8) {
                // 判断用户名长度是否大于8位
                for (int i = 0; i < username.length(); i++) {
                    char ch = username.charAt(i); // 获取每一位字符
                    if (Character.isLetterOrDigit(ch)) {
                        con = true;
                    } else {
                        throw new IllegalArgumentException("用户名只能由字母和数字组成！");
                    }
                }
            } else {
                throw new IllegalArgumentException("用户名长度必须大于 8 位！");
            }
            return con;
        }
        public static void main(String[] args) {
            ValidateUserName te = new ValidateUserName();
            Scanner input = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String username = input.next();
            try {
                boolean con = te.validateUserName(username);
                if (con) {
                    System.out.println("用户名输入正确！");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    
}
