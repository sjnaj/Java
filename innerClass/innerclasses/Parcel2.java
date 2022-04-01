/**
 * @Author: fengsc
 * @Date: 2022-03-31 10:35:23
 * @LastEditTime: 2022-03-31 11:08:28
 */
//局部内部类
package innerclasses;

public class Parcel2 {
    public Destination destination(String s) {
        final class PDestination implements Destination {// *限定符只能是final或abstract
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    protected Contents contents(int i) {
        final class PContents implements Contents {
            private int i;

            private PContents(int c) {
                i = c;
            }

            @Override
            public int value() {
                return i;
            }
        }
        return new PContents(i);
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        Contents c = p.contents(12);
        Destination d = p.destination("Tasmania");
        System.out.println("Destination: " + d.readLabel());
        System.out.println("Contents: " + c.value());
    }

}
/*
 * Destination: Tasmania
 * Contents: 12
 */
