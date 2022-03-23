/*
 * @Author: fengsc
 * @Date: 2022-03-22 09:58:21
 * @LastEditTime: 2022-03-22 10:17:18
 */
public class TestClone {
    public static void main(String[] args) {
        CloneableRectangle rectangle1= new CloneableRectangle(3,5);
        CloneableRectangle rectangle2= (CloneableRectangle) rectangle1.clone();
        System.out.println(rectangle1.getWidth());
        System.out.println(rectangle2.getWidth());
        System.out.println(rectangle1.hashCode());
        System.out.println(rectangle2.hashCode());
        System.out.println(rectangle1.getDateCreated()==rectangle2.getDateCreated());//引用同一个对象
        rectangle2=rectangle1.deepClone();
        System.out.println(rectangle2.getDateCreated()==rectangle1.getDateCreated());//不同对象


        

    }
    
}
