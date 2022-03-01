/*
 * @Author: fengsc
 * @Date: 2022-02-24 00:23:38
 * @LastEditTime: 2022-02-24 21:53:45
 */
public class MainTest {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(2.5, 2);
        MyPoint p2 = new MyPoint(4.2, 3);
        MyPoint p3 = new MyPoint(5, 3.5);
        System.out.println(p1.distance(p2));
        System.out.println(MyPoint.getIntersectionPoint(p1,p2,p1,p3));
        Triangle2D t1=new Triangle2D(p1,p2,p3);
        System.out.println(t1.getArea());
        System.out.println(t1.contains(new MyPoint(3,3)));
        System.out.println(t1.contains(2.9,2));
        System.out.println(t1.contains(4,1));
        System.out.println(t1.contains(3,2.8));
        System.out.println(t1.overlaps(t1));
        System.out.println(t1.overlaps(new MyPoint(2,5.5),new MyPoint(4,1),new MyPoint(1,3.4)));
    }

}
