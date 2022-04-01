/**
 * @Author: fengsc
 * @Date: 2022-03-26 14:34:26
 * @LastEditTime: 2022-03-26 14:44:45
 */
class Cup {
    Cup(int maker) {
        System.out.println("Cup(" + maker + ")");
    }

    void f(int maker) {
        System.out.println("f(" + maker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;
    static {//*显式静态初始化
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }
}

public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup1.f(99);//调用链上的静态初始化也被执行
        Cups cup=new Cups();//静态块只执行一次
    }

}
/*
 * Inside main()
 * Cup(1)
 * Cup(2)
 * f(99)
 * Cups()
 */
