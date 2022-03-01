/*
 * @Author: fengsc
 * @Date: 2022-02-26 11:24:29
 * @LastEditTime: 2022-02-26 11:35:56
 */
public class TestCasting {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Man();
        Man m1 = new Man();
        System.out.println(p1 instanceof Man); // false
        System.out.println(p2 instanceof Man); // true
        // *实际类型是Man的实例(子类的实例是其本身和父类的实例)，可以向下转型
        System.out.println(m1 instanceof Man); // true

        System.out.println(animalCall(new Sheep()));//需要定义为静态函数
    }

    public static Object animalCall(Animal a) {
        String tip = "这个动物不是牛！";
        // 判断参数a是不是Cow的对象
        return a instanceof Cow ? (Cow) a : tip;
    }

}

 class Person {
}

 class Man extends Person {
}

class Animal {
}

class Cow extends Animal {
}

class Sheep extends Animal {
}