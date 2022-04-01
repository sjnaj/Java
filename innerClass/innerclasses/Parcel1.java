/**
 * @Author: fengsc
 * @Date: 2022-03-31 10:34:56
 * @LastEditTime: 2022-03-31 11:03:50
 */
//实例内部类隐藏接口实现
package innerclasses;

class Parcel1 {
    private class PContents implements Contents {
        private int i;

        private PContents(int c) {
            i = c;
        }

        @Override
        public int value() {
            return i;
        }
    }

    protected final class PDestination implements Destination {
        private String label;

        private PDestination(String whereto) {
            label = whereto;
        }

        @Override
        public String readLabel() {
            return label;
        }

    }

    public Destination destination(String s) {
        return new PDestination(s);//*外部类访问内部类的private构造函数
    }

    public Contents contents(int i) {
        return new PContents(i);
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        Contents c = p.contents(12);
        Destination d = p.destination("Tasmania");
        System.out.println("Destination: " + d.readLabel());
        System.out.println("Contents: " + c.value());

    }
}
