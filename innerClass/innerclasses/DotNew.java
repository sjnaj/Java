/**
 * @Author: fengsc
 * @Date: 2022-03-31 10:13:41
 * @LastEditTime: 2022-03-31 10:15:09
 */
package innerclasses;

public class DotNew {
    class Inner {
    }

    public static void main(String[] args) {
        DotNew dotNew = new DotNew();
        DotNew.Inner in = dotNew.new Inner();
    }

}
