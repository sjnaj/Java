/**
 * @Author: fengsc
 * @Date: 2022-03-30 17:37:39
 * @LastEditTime: 2022-03-30 18:13:28
 */
package interfaces;

public class Implementation implements InterfaceWithDefault {
    @Override
    public void firstMethod() {
        System.out.println("firstMethod");

    }

    @Override
    public void secondMethod() {
        System.out.println("secondMethod");
    }

    public static void main(String[] args) {
        InterfaceWithDefault i = new Implementation();
        i.firstMethod();
        i.secondMethod();
        i.newMethod();//default方法，又称守卫方法和虚拟拓展方法
        Implementation i1= new Implementation();//两种方式结果等价
        i1.firstMethod();
        i1.secondMethod();
        i1.newMethod();
    }
}
// firstMethod
// secondMethod
// newMethod
// firstMethod
// secondMethod
// newMethod