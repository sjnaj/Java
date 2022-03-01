/*
 * @Author: fengsc
 * @Date: 2022-02-25 21:01:57
 * @LastEditTime: 2022-02-27 11:56:47
 */
package geometry;

public class Circle extends GeometricObject {
    private double radius;

    // *没有显式调用时，自动将super()作为构造函数的第一条语句
    public Circle() {
    }

    public Circle(double radius) {
        super();
        setRadius(radius);
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws IllegalArgumentException {
        if (radius >= 0)
            this.radius = radius;
        else {
            throw new IllegalArgumentException("Radius cannot be nagative");
        }
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
    }

    @Override
    public String toString() {
        return super.toString() + "\nradius is: " + radius;
    }

}
