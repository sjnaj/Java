/**
 * @Author: fengsc
 * @Date: 2022-03-27 22:09:35
 * @LastEditTime: 2022-03-27 22:15:27
 */
public class AutoBoxingVarargs {
    static void f(Integer... args) {
        for (Integer i : args) {
            System.out.print(i.getClass()+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        f(10,new Integer(10),20);//int被提升
    }

}
//class java.lang.Integer class java.lang.Integer class java.lang.Integer 