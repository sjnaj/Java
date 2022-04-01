/**
 * @Author: fengsc
 * @Date: 2022-03-29 20:38:40
 * @LastEditTime: 2022-03-29 20:57:44
 */

public class PrivateOverride {
    private void f(){
        System.out.println("It's private");
    }
    public final void g(){
        System.out.println("It's private");

    }
    public static  void main(String[] args){
        PrivateOverride obj=new Derived();
        obj.f();//两个f不相关，调用的是基类的，说明查找是从上到下的
    }
}
class Derived extends PrivateOverride{
    public void f(){//基类的f不可重写，此函数不构成重写
        System.out.println("It's public");
    }
    // public void g(){//禁止重写
    //     System.out.println("It's public");
    // }
}