/**
 * @Author: fengsc
 * @Date: 2022-03-27 22:16:20
 * @LastEditTime: 2022-03-27 22:23:18
 */
public class OverloadingArgs {
    static void f(Character... args) {
        System.out.println("first");
        for (Character c : args) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
    static void f(Integer... args){
        System.out.println("second");
        for(Integer i: args){
            System.out.println(i+" ");
        }
        System.out.println();
    }
    static void f(Long... args){
        System.out.println("third");
    }
    public static void main(String[] args){
        f('a','b','c');
        f(1,2,3);
        f(0);
        f(0L);
        //!f();//The method f(Character[]) is ambiguous for the type OverloadingArgs
    }


}
// first
// a b c 
// second
// 1 
// 2 
// 3 

// second
// 0 

// third