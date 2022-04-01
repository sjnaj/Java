/**
 * @Author: fengsc
 * @Date: 2022-03-31 16:30:14
 * @LastEditTime: 2022-03-31 16:52:47
 */
package innerclasses;

abstract class Base {
    Base(int i) {
        System.out.println("Base constructor: i=" + i);
    }

    public abstract void f();
}

public class AnonymousConstructor {
    public static Base getBase(int i) {
        return new Base(i) {//传递给基类的参数不要求是final的
            {// 实例初始化替代构造器
                System.out.println("Inside instance initializer");
            }

            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        AnonymousConstructor a = new AnonymousConstructor();
        Base b = a.getBase(12);
        b.f();
    }

}
// Base constructor: i=12
// Inside instance initializer
// In anonymous f()
