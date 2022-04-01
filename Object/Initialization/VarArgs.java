/**
 * @Author: fengsc
 * @Date: 2022-03-26 19:35:38
 * @LastEditTime: 2022-03-27 21:49:08
 */
class A {
}

public class VarArgs {
    static void printArray(Object[] args) {
        for (Object obj : args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(new Object[] { new Integer(10), new Double(10.5), new Float(11.1) });
        printArray(new Object[] { "lalala", "lilili", "okokok" });
        printArray(new Object[] { new A(), new A(), new A() });
        Object[] array = { new A(), new A(), new A() };
        printArray(array);
        Object[] array2;
        array2 = new Object[] { new A(), new A(), new A() };
        printArray(array2);

    }

}
// 10 10.5 11.1 
// lalala lilili okokok 
// A@78308db1 A@27c170f0 A@5451c3a8 
// A@2626b418 A@5a07e868 A@76ed5528 
// A@2c7b84de A@3fee733d A@5acf9800 