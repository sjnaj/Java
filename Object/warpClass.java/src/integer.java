/*
 * @Author: fengsc
 * @Date: 2022-02-22 19:34:49
 * @LastEditTime: 2022-02-22 19:40:50
 */
public class integer {
    public static void main(String[] args) {
        Integer integer1 = new Integer(100); // 以 int 型变量作为参数创建 Integer 对象
        Integer integer2 = new Integer("100"); // 以 String 型变量作为参数创建 Integer 对象
        {
            String str = "456";
            int num = Integer.parseInt(str); // 将字符串转换为int类型的数值
            int i = 789;
            String s = Integer.toString(i); // 将int类型的数值转换为字符串
        }
        int num = 40;
        String str = Integer.toString(num); // 将数字转换成字符串
        String str1 = Integer.toBinaryString(num); // 将数字转换成二进制
        String str2 = Integer.toHexString(num); // 将数字转换成八进制
        String str3 = Integer.toOctalString(num); // 将数字转换成十六进制
        System.out.println(str + "的二进制数是：" + str1);
        System.out.println(str + "的八进制数是：" + str3);
        System.out.println(str + "的十进制数是：" + str);
        System.out.println(str + "的十六进制数是：" + str2);

        {
            int max_value = Integer.MAX_VALUE; // 获取 int 类型可取的最大值
            int min_value = Integer.MIN_VALUE; // 获取 int 类型可取的最小值
            int size = Integer.SIZE; // 获取 int 类型的二进制位(32)
            Class c = Integer.TYPE; // 获取基本类型 int 的 Class 实例
            
        }

    }

}
