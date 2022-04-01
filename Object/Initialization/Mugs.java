/**
 * @Author: fengsc
 * @Date: 2022-03-26 14:46:30
 * @LastEditTime: 2022-03-26 15:07:04
 */
class Mug {
    Mug(int maker) {
        System.out.println("Mug(" + maker + ")");
    }

    void f(int maker) {
        System.out.print("f(" + maker + ")");
    }
}

public class Mugs {
    Mug mug1;
    Mug mug2;
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        System.out.println("mug1 & mug2 initialized");
    }

    Mugs() {
        System.out.println("Mugs()");

    }

    Mugs(int i) {
        System.out.println("Mugs(int)");
    }

    public static void main(String[] args) {
        System.out.println("Inside main()");
        new Mugs();
        System.out.println("new Mugs() completed");
        new Mugs(1);
        System.out.println("new Mugs(1) completed");
        //与静态显式初始化的区别在于初始块(字句)每次都会运行
        //初始化字句在构造器之前进行，可以用于进行公共部分的初始化
    }

}
// Inside main()
// Mug(1)
// Mug(2)
// mug1 & mug2 initialized
// Mugs()
// new Mugs() completedMug(1)
// Mug(2)
// mug1 & mug2 initialized
// Mugs(int)
// new Mugs(1) completed