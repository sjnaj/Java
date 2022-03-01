/*
 * @Author: fengsc
 * @Date: 2022-02-26 17:36:52
 * @LastEditTime: 2022-02-26 18:03:32
 */
// 实例内部类是指没有用 static 修饰的内部类，有的地方也称为非静态内部类。
// 实例内部类有如下特点:
// *1）在外部类的静态方法和外部类以外的其他类中，必须通过外部类的实例创建内部类的实例。 
// *2）在实例内部类中，可以访问外部类的所有成员。(如果有多层嵌套，则内部类可以访问所有外部类的成员。)
// *3）在外部类中不能直接访问内部类的成员，而必须通过内部类的实例去访问。如果类 A 包含内部类 B，类 B 中包含内部类 C，则在类 A 中不能直接访问类 C，而应该通过类 B 的实例去访问类 C。
// *4）外部类实例与内部类实例是一对多的关系，也就是说一个内部类实例只对应一个外部类实例，而一个外部类实例则可以对应多个内部类实例。
// *5）在实例内部类中不能定义 static 成员，除非同时使用 final 和 static 修饰。 

public class InstanceInnerClass {
    public int a = 100;
    static int b = 100;
    final int c = 100;
    private int d = 100;

    public String method1() {
        return "实例方法1";
    }

    public static String method2() {
        return "静态方法2";
    }

    public void method3() {
        Inner i = new Inner(); // 不需要创建外部类实例
        System.out.println("lala");
    }

    public static void method4() {
        Inner i = new InstanceInnerClass().new Inner(); // 需要创建外部类实例
    }

    class Inner {
        // static int i = 1;
        final static int i = 1;

        int a2 = a + 1; // 访问public的a
        int b2 = b + 1; // 访问static的b
        int c2 = c + 1; // 访问final的c
        int d2 = d + 1; // 访问private的d

        String str1 = method1(); // 访问实例方法method1

        String str2 = method2(); // 访问静态方法method2
        

    }

    Inner i = new Inner(); // 不需要创建外部类实例

    class Inner2 {
        Inner i = new Inner(); // 不需要创建外部类实例
    }
}

class OtherClass {
    InstanceInnerClass.Inner i = new InstanceInnerClass().new Inner(); // 需要创建外部类实例
}
