/*
 * @Author: fengsc
 * @Date: 2022-02-26 18:12:38
 * @LastEditTime: 2022-02-26 20:27:23
 */
// *局部内部类是指在一个方法中定义的内部类。
// 局部内部类有如下特点：

// *1）局部内部类与局部变量一样，不能使用访问控制修饰符（public、private 和 protected）和 static 修饰符修饰。

// *2）局部内部类只在当前方法中有效。 
// *3）局部内部类中不能定义 static 成员。

// *4）局部内部类中还可以包含内部类，但是这些内部类也不能使用访问控制修饰符（public、private 和 protected）和 static 修饰符修饰。

// *5）在局部内部类中可以访问外部类的所有成员。

// *6）在局部内部类中只可以访问当前方法中 final 类型的参数与变量。如果方法中的成员与外部类中的成员同名，
// 则可以使用 <OuterClassName>.this.<MemberName> 的形式访问外部类中的成员。 
public class LocalInnerClass {

    int a = 0;
    int d = 0;

    public void method() {
        int b = 0;
        final int c = 0;
        final int d = 10;
        class Inner {
            int a2 = a; // 访问外部类中的成员
         int b2 = b; // !Java7以下编译出错
         //也就是说从 Java 8 开始，它不要求程序员必须将访问的局部变量显式的声明为 final 的。只要该变量不被重新赋值就可以。
         //!一个非 final 的局部变量或方法参数，其值在初始化后就从未更改，那么该变量就是 effectively final。
         //!规则没有改变，Lambda 表达式和匿名内部类访问的局部变量必须是 final 的，只是不需要程序员显式的声明变量为 final 的，从而节省时间。
            int c2 = c; // 访问方法中的成员
            int d2 = d; // 访问方法中的成员
            int d3 = LocalInnerClass.this.d; // 访问外部类中的成员
        }
        Inner i = new Inner();
        System.out.println(i.d2); // 输出10
        System.out.println(i.d3); // 输出0
    }

    public static void main(String[] args) {
        LocalInnerClass t = new LocalInnerClass();
        t.method();
    }
}
