/**
 * @Author: fengsc
 * @Date: 2022-03-27 22:24:35
 * @LastEditTime: 2022-03-27 22:46:57
 */
public class OverloadingArgs2 {
    static void f(Character... args) {
    System.out.println("first");
    }

   

    static void f(int i, Character... args) {
        System.out.println("second");
    }

    public static void main(String[] args) {
        f();
        //!f('a','b');不会去调用最适合的
        f(1, 'a');
    }

}