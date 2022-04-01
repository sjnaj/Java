/**
 * @Author: fengsc
 * @Date: 2022-03-27 21:38:27
 * @LastEditTime: 2022-03-27 22:22:08
 */
public class NewVarArgs {
    static void printArray(Object... args) {
        for(Object obj: args) {
            System.out.print(obj+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        printArray(new Object[] {new Integer(10),new Double(10.5),new Float(10.2F)});
        printArray(10,10.5,10.2F);//可变参数用法，可以使用任何类型任何合法数量的参数，包括基本类型
        printArray("one","two","three");
        printArray(new Object[] {new A(), new A(), new A() });
        printArray((Object[])new Integer[]{1,2,3,4,5});//强制转换去除警告
        printArray();

    }
}
// 10 10.5 10.2 
// 10 10.5 10.2 
// one two three 
// A@78308db1 A@27c170f0 A@5451c3a8 
// 1 2 3 4 5 