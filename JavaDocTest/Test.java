/**
 * ClassComment
 * 
 * @Author: fengsc
 * @Date: 2022-03-22 21:45:23
 * @LastEditTime: 2022-03-22 22:37:42
 * @Description: Do not edit
 */

// 若要输出author选项，需要改为@author xxx形式,并使用javadoc -author -d 文件夹
// xx.java.在同名html文件中可看到author
// 还可以嵌入html语句

public class Test {
    /**
     * FieldComment
     * 
     * <pre>
     * int i;
     * </pre>
     */
    // FieldComment貌似不能正常显示
    /**
     * FuncComment
     * 求输入两个参数范围以内整数的和
     * 
     * @param n 接收的第一个参数，范围起点
     * @param m 接收的第二个参数，范围终点
     * @return 两个参数范围以内整数的和
     */
    public int add(int n, int m) {
        int sum = 0;
        for (int i = n; i <= m; i++) {
            sum = sum + i;
        }
        return sum;
    }

}
