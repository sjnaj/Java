/*
 * @Author: fengsc
 * @Date: 2022-02-22 18:40:10
 * @LastEditTime: 2022-02-23 14:36:02
 */
public class basic {

    // *基本数据类型转换为包装类的过程称为装箱，例如把 int 包装成 Integer 类的对象；
    // *包装类变为基本数据类型的过程称为拆箱，例如把 Integer 类的对象重新简化为 int。

    public static void main(String[] args) {
        int m = 500;
        Integer obj = new Integer(m); // 手动装箱
        int n = obj.intValue(); // 手动拆箱
        System.out.println("n = " + n);

        Integer obj1 = new Integer(500);
        System.out.println("obj等价于obj1的返回结果为" + obj.equals(obj1));//被重写，整数相等即为真
        Integer.parseInt("12");
    }
    // *字符串转数值类型：Interger.parseInt(String，),Double.parseDouble(String) ...
    //*数值类型转字符串： Interget.toString(int,scale=10);

}