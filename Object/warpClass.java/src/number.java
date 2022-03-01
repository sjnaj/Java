/*
 * @Author: fengsc
 * @Date: 2022-02-22 19:54:01
 * @LastEditTime: 2022-02-22 19:54:01
 */
public class number {
    public static void main(String[] args) {
        Number num = new Double(12.5);
        System.out.println("返回 double 类型的值：" + num.doubleValue());
        System.out.println("返回 int 类型的值：" + num.intValue());
        System.out.println("返回 float 类型的值：" + num.floatValue());
    }

}
