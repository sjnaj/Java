/**
 * @Author: fengsc
 * @Date: 2022-03-29 21:16:59
 * @LastEditTime: 2022-03-29 21:23:42
 */
class StaticSuper {
    public int i=0;
    public static void f() {
        System.out.println("It's StaticSuper!");
    }
}

class StaticSub extends StaticSuper {
    public int i=1;
    public static void f() {
        System.out.println("It's StaticSub!");
    }
}

public class StaticPloymorphsim {
    public static void main(String[] args) {
        StaticSuper s = new StaticSub();//!静态类和域不可重写，不能构成多态
        s.f();
        System.out.println(s.i);//都调用的是基类的
    }

}
// It's StaticSuper!
// 0