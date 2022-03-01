/*
 * @Author: fengsc
 * @Date: 2022-02-22 18:47:51
 * @LastEditTime: 2022-02-22 19:33:01
 */
public class object {
    public static void main(String[] args) {
        // *Object 是 Java 类库中的一个特殊类，也是所有类的父类。也就是说，Java 允许把任何类型的对象赋给 Object 类型的变量。
        // *当一个类被定义后，如果没有指定继承的父类，那么默认父类就是 Object 类。因此，以下两个类表示的含义是一样的。

        // public class MyClass{…}
        // public class MyClass extends Object {…}

        // *Object 类的 toString() 方法返回“运行时类名@十六进制哈希码”格式的字符串，但很多类都重写了 Object 类的
        // toString()方法，用于返回可以表述该对象信息的字符串。
        // *哈希码（hashCode），每个 Java 对象都有哈希码属性，哈希码可以用来标识对象，提高对象在集合操作中的执行效率。
        class Demo {
        }
        Demo demo = new Demo();
        System.out.println(demo);// 运行时类名@十六进制哈希码
        // *由于 Java 所有的类都是 Object 类的子类，所以任何 Java 对象都可以调用 Object 类的方法
        System.out.println(demo.hashCode());// 十进制哈希码
        class Demo2 {

        }
        Demo2 demo2 = new Demo2();
        System.out.println(demo.equals(demo2));// false
        String s1 = "lala";
        String s2 = "lala";
        System.out.println(s1.equals(s2));// true;被重写

        printClassInfo(new String());

        // *既然 Object 类是所有对象的父类，则所有的对象都可以向 Object 进行转换，
        // *在这其中也包含了数组和接口类型，即一切的引用数据类型都可以使用 Object 进行接收。

        // 对象向上转型
        Object obj = demo;
        // 对象向下转型
        Demo x = (Demo) obj;

    }

    public static void printClassInfo(Object obj) {
        // 获取类名
        System.out.println("类名：" + obj.getClass().getName());
        // 获取父类名
        System.out.println("父类：" + obj.getClass().getSuperclass().getName());
        System.out.println("实现的接口有：");
        // 获取实现的接口并输出
        for (int i = 0; i < obj.getClass().getInterfaces().length; i++) {
            System.out.println(obj.getClass().getInterfaces()[i]);
        }
    }

}