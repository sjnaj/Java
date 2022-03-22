/*
 * @Author: fengsc
 * @Date: 2022-03-22 00:12:00
 * @LastEditTime: 2022-03-22 00:37:35
 */
public class SortRectangles {
    public static void main(String[] args) {
        ComparableRectangle[] rectangles = {new ComparableRectangle(3.4,5.4),new ComparableRectangle(13.4,55.4),new ComparableRectangle(7.4,35.4)};
        java.util.Arrays.sort(rectangles);
        for(geometry.Rectangle rectangle:rectangles){
            System.out.println(rectangle+" ");
            System.out.println(rectangle.hashCode());
        }
        System.out.println();
    }
    
}
