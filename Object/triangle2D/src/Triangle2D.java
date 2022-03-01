/*
 * @Author: fengsc
 * @Date: 2022-02-23 20:16:54
 * @LastEditTime: 2022-02-24 21:51:31
 */
public class Triangle2D {

    private MyPoint x, y, z;
    private double a, b, c;

    public Triangle2D(MyPoint x, MyPoint y, MyPoint z) {
        this.x = x;
        this.y = y;
        this.z = z;
        a = MyPoint.distance(x, y);
        b = MyPoint.distance(x, z);
        c = MyPoint.distance(y, z);
    }

    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public boolean contains(MyPoint point) {
        double crossProduct1 = (y.getX() - x.getX()) * (point.getY() - x.getY())
                - (point.getX() - x.getX()) * (y.getY() - x.getY());
        double crossProduct2 = (z.getX() - y.getX()) * (point.getY() - y.getY())
                - (point.getX() - y.getX()) * (z.getY() - y.getY());
        double crossProduct3 = (x.getX() - z.getX()) * (point.getY() - z.getY())
                - (point.getX() - z.getX()) * (x.getY() - z.getY());
        return (crossProduct1 > 0 && crossProduct2 > 0 && crossProduct3 > 0)
                || (crossProduct1 < 0 && crossProduct2 < 0 && crossProduct3 < 0);// *在所有边的同侧

    }

    public boolean contains(double x, double y) {
        return contains(new MyPoint(x, y));
    }

    public boolean contains(Triangle2D t) {
        return (contains(t.x) && contains(t.y) && contains(t.z));
    }

    public boolean overlaps(Triangle2D t) {
        MyPoint[] vertexSet1 = { x, y, z };
        MyPoint[] vertexSet2 = { t.x, t.y, t.z };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                MyPoint point = MyPoint.getIntersectionPoint(vertexSet1[i], vertexSet1[(i + 1) % 3], vertexSet2[j],
                        vertexSet2[(j + 1) % 3]);
                if (!Double.isNaN(point.getX())) {// 存在交点
                    return true;
                }
            }
        }
        return false;
    }

    public boolean overlaps(MyPoint x, MyPoint y, MyPoint z) {
        return overlaps(new Triangle2D(x, y, z));
    }
}