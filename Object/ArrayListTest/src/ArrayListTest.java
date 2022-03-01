
/*
 * @Author: fengsc
 * @Date: 2022-02-26 11:51:23
 * @LastEditTime: 2022-02-26 15:00:20
 */
import java.util.ArrayList;
import geometry.Circle;

public class ArrayListTest {
    public static void main(String[] args) {
        // ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> cityList = new ArrayList<>();// type inference
        // 添加元素到末尾
        cityList.add("London");
        cityList.add("Denver");
        cityList.add("Paris");
        cityList.add("Miami");
        cityList.add("Seoul");
        cityList.add("Tokey");
        System.out.println("List size: " + cityList.size());
        System.out.println("Is Miami in the city? " + cityList.contains("Miami"));
        System.out.println("The location of Denver in the list? " + cityList.indexOf("Denver"));
        System.out.println("Is the list empty? " + cityList.isEmpty());
        cityList.add(2, "Xian");
        cityList.remove("Miami");
        cityList.remove(1);
        System.out.println(cityList);// 调用toString方法
        cityList.set(0, "Beijing");
        for (int i = cityList.size() - 1; i > -1; i--) {
            System.out.print(cityList.get(i) + " ");
        }
        System.out.println();
        ArrayList<Circle> list = new ArrayList<>();
        list.add(new Circle(2));
        list.add(new Circle(3));
        System.out.println("The area of the circle 0: " + list.get(0).getArea());

        {
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(10);
            al.add(20);
            al.add(30);
            al.add(40);

            Integer[] arr = new Integer[al.size()];
            arr = al.toArray(arr);

            for (Integer x : arr)
                System.out.print(x + " ");
        }
        {
            String[] array = new String[cityList.size()];
            cityList.toArray(array);// *ArrayList转换为array
            ArrayList<String> list2 = new ArrayList<>(java.util.Arrays.asList(array));// *array转换为ArrayList
        }
        {
            Integer[] array = { 3, 5, 95, 4, 15 };
            ArrayList<Integer> list3 = new ArrayList<>(java.util.Arrays.asList(array));
            System.out.println("max is : " + java.util.Collections.max(list3));
            System.out.println("min is : " + java.util.Collections.min(list3));

        }

    }
}
