/*
 * @Author: fengsc
 * @Date: 2022-02-23 21:15:36
 * @LastEditTime: 2022-02-24 21:19:10
 */
public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {
        this(0, 0);
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(int x, int y) {
        return Math.sqrt((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y));
    }

    public double distance(MyPoint point) {
        return Math.sqrt((point.x - x) * (point.x - x) + (point.y - y) * (point.y - y));
    }

    public static double distance(MyPoint point1, MyPoint point2) {
        return Math.sqrt((point1.x - point2.x) * (point1.x - point2.x) + (point1.y - point2.y) * (point1.y - point2.y));
    }

    public String toString() {
        return "(" + x + ',' + y + ')';
    }

    public static MyPoint getIntersectionPoint(MyPoint p1, MyPoint p2, MyPoint p3, MyPoint p4) {
        double a = p1.getY() - p2.getY();
        double b = p2.getX() - p1.getX();
        double c = p3.getY() - p4.getY();
        double d = p4.getX() - p3.getX();
        double e = a * p1.getY() + b * p1.getX();
        double f = c * p3.getY() + d * p3.getX();
        double delta = a * d - b * c;
        if (delta != 0) {
            double px = (e * d - b * f) / delta;
            double py = (a * f - e * c) / delta;
            double maxY = Math.max(p1.getY(), Math.max(p2.getY(), Math.max(p3.getY(), p4.getY())));
            double maxX = Math.max(p1.getX(), Math.max(p2.getX(), Math.max(p3.getX(), p4.getX())));
            double minY = Math.min(p1.getY(), Math.min(p2.getY(), Math.min(p3.getY(), p4.getY())));
            double minX = Math.min(p1.getX(), Math.min(p2.getX(), Math.min(p3.getX(), p4.getX())));
            if (px < maxX && px > minX && py < maxY && py > minY)// 在线段范围内，不包括端点
                return new MyPoint(px, py);
        }
        return new MyPoint(Double.NaN, Double.NaN);
    }

}
