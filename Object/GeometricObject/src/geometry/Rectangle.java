/*
 * @Author: fengsc
 * @Date: 2022-02-25 21:10:46
 * @LastEditTime: 2022-02-27 11:49:16
 */
package geometry;

public class Rectangle extends GeometricObject {
    private double width;
    private double height;

    public Rectangle() {// 会自动调用父类的无参构造
    }

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (height + width);
    }

}