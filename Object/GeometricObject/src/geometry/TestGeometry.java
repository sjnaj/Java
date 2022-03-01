/*
 * @Author: fengsc
 * @Date: 2022-02-25 22:19:14
 * @LastEditTime: 2022-02-27 12:06:01
 */
package geometry;

public class TestGeometry {
    public static void main(String[] args) {
        displayObject(new Circle(1, "red", false));// *不新建包会和外部的Circle发生冲突，除非自定义launch.json或手动编译
        displayObject(new Rectangle(1, 1, "black", true));

        // Circle c = new Circle(-1);
        Circle c = new Circle(10);
        System.out.println("numberOfObjects: " + c.getNumberOfObjects());// 3
    }   

    public static void displayObject(GeometricObject object) {
        System.out.println("Created on " + object.getDateCreated() + ",Color is " + object.getColor());
    }

}
