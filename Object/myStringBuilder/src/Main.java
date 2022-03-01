/*
 * @Author: fengsc
 * @Date: 2022-02-23 14:20:39
 * @LastEditTime: 2022-02-23 20:12:50
 */
public class Main {
    public static void main(String[] args) {
        MyStringBuilder sb=new MyStringBuilder();
        System.out.println(sb.capacity());
        sb.append("lala");
        System.out.println(sb);
        System.out.println(sb.toUpperCase());
        System.out.println(sb.reverse());
        System.out.println(sb.substring(0,2));
        System.out.println(sb.append("hihi"));
    }

}
