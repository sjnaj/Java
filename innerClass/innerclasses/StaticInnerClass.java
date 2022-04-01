/**
 * @Author: fengsc
 * @Date: 2022-02-26 18:04:39
 * @LastEditTime: 2022-03-31 10:01:22
 */
/*
 * @Author: fengsc
 * @Date: 2022-02-26 18:04:39
 * @LastEditTime: 2022-02-26 20:23:36
 */
// 静态内部类有如下特点:

// *1）在创建静态内部类的实例时，不需要创建外部类的实例。
// *2）静态内部类中可以定义静态成员和实例成员。外部类以外的其他类需要通过完整的类名访问静态内部类中的静态成员，
// *如果要访问静态内部类中的实例成员，则需要通过静态内部类的实例。 
// *3）静态内部类可以直接访问外部类的静态成员，如果要访问外部类的实例成员，则需要通过外部类的实例去访问。 
package innerclasses;
public class StaticInnerClass {
    int a = 2;
    static int b = 0; // 静态变量

    static class Inner {
        int a = 0; // 实例变量a
        static int b = 0; // 静态变量 b

        StaticInnerClass o = new StaticInnerClass();
        int a2 = o.a; // 访问实例变量
        int b2 = b; // 访问静态变量
    }
}

class OtherClass1 {
    StaticInnerClass.Inner oi = new StaticInnerClass.Inner();
    int a2 = oi.a; // 访问实例成员
    int b2 = StaticInnerClass.Inner.b; // 访问静态成员
}
