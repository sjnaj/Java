/**
 * @Author: fengsc
 * @Date: 2022-03-31 11:09:26
 * @LastEditTime: 2022-03-31 16:29:13
 */
//匿名内部类
package innerclasses;

public class Parcel4 {
    public Contents contents(final int content) {// *final可以省略，最好加上作为hint
        return new Contents() {// *创建一个继承自Contents的类并向上转型后返回对象
            private int i = content;

            @Override
            public int value() {
                return i;
            }

        };
    }

    public static void main(String[] args) {
        Parcel4 Parcel4 = new Parcel4();
        int c = Parcel4.contents(66).value();
        System.out.println(c);

    }

}
