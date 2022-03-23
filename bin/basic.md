<!--
 * @Author: fengsc
 * @Date: 2022-03-21 23:44:04
 * @LastEditTime: 2022-03-22 14:19:04
-->
抽象类和普通类的主要有三点区别：

　　1）抽象方法必须为public或者protected（因为如果为private，则不能被子类继承，子类便无法实现该方法），缺省情况下默认为public。

　　2）抽象类不能用来创建对象；

　　3）如果一个类继承于一个抽象类，则子类必须实现父类的抽象方法。如果子类没有实现父类的抽象方法，则必须将子类也定义为为abstract类。

　　在其他方面，抽象类和普通的类并没有区别。

接口中可以含有 变量和方法。但是要注意，接口中的变量会被隐式地指定为public static final变量（并且只能是public static final变量，用private修饰会报编译错误），而方法会被隐式地指定为public abstract方法且只能是public abstract方法（用其他关键字，比如private、protected、static、 final等修饰会报编译错误），并且接口中所有的方法不能有具体的实现，也就是说，接口中的方法必须都是抽象方法。从这里可以隐约看出接口和抽象类的区别，接口是一种极度抽象的类型，它比抽象类更加“抽象”，并且一般情况下不在接口中定义变量。

抽象类和接口的区别

1.语法层面上的区别

　　1）抽象类可以提供成员方法的实现细节，而接口中只能存在public abstract 方法；

　　2）抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是public static final类型的；

　　3）接口中不能含有静态代码块以及静态方法，而抽象类可以有静态代码块和静态方法；

　　4）一个类只能继承一个抽象类，而一个类却可以实现多个接口。

2.设计层面上的区别

　　1）抽象类是对一种事物的抽象，即对类抽象，而接口是对行为的抽象。抽象类是对整个类整体进行抽象，包括属性、行为，但是接口却是对类局部（行为）进行抽象。举个简单的例子，飞机和鸟是不同类的事物，但是它们都有一个共性，就是都会飞。那么在设计的时候，可以将飞机设计为一个类Airplane，将鸟设计为一个类Bird，但是不能将 飞行 这个特性也设计为类，因此它只是一个行为特性，并不是对一类事物的抽象描述。此时可以将 飞行 设计为一个接口Fly，包含方法fly( )，然后Airplane和Bird分别根据自己的需要实现Fly这个接口。然后至于有不同种类的飞机，比如战斗机、民用飞机等直接继承Airplane即可，对于鸟也是类似的，不同种类的鸟直接继承Bird类即可。从这里可以看出，继承是一个 "是不是"的关系，而 接口 实现则是 "有没有"的关系。如果一个类继承了某个抽象类，则子类必定是抽象类的种类，而接口实现则是有没有、具备不具备的关系，比如鸟是否能飞（或者是否具备飞行这个特点），能飞行则可以实现这个接口，不能飞行就不实现这个接口。

　　2）设计层面不同，抽象类作为很多子类的父类，它是一种模板式设计。而接口是一种行为规范，它是一种辐射式设计。什么是模板式设计？最简单例子，大家都用过ppt里面的模板，如果用模板A设计了ppt B和ppt C，ppt B和ppt C公共的部分就是模板A了，如果它们的公共部分需要改动，则只需要改动模板A就可以了，不需要重新对ppt B和ppt C进行改动。而辐射式设计，比如某个电梯都装了某种报警器，一旦要更新报警器，就必须全部更新。也就是说对于抽象类，如果需要添加新的方法，可以直接在抽象类中添加具体的实现，子类可以不进行变更；而对于接口则不行，如果接口进行了变更，则所有实现这个接口的类都必须进行相应的改动。


重写compareTO会建议重写equal，重写equal会建议重写hashcode，额

《Effective Java》中提出了一种简单通用的hashCode算法

A、初始化一个整形变量，为此变量赋予一个非零的常数值，比如int result = 17;

B、选取equals方法中用于比较的所有域（之所以只选择equals()中使用的域，是为了保证上述原则的第1条），然后针对每个域的属性进行计算：

如果是boolean值，则计算 f ? 1:0；
如果是byte\char\short\int,则计算 (int)f；
如果是long值，则计算 (int)(f ^ (f >>> 32))；
如果是float值，则计算 Float.floatToIntBits(f)；
如果是double值，则计算 Double.doubleToLongBits(f)，然后返回的结果是long,再用规则(3)去处理long,得到int；
如果是对象应用，如果equals方法中采取递归调用的比较方式，那么hashCode中同样采取递归调用hashCode的方式。否则需要为这个域计算一个范式，比如当这个域的值为null的时候，那么hashCode 值为0；
如果是数组，那么需要为每个元素当做单独的域来处理。**java.util.Arrays.hashCode 方法包含了8种基本类型数组和引用数组的hashCode计算，算法同上**。

遍历所有属性    

```java
public static void eachProperties(Object model) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    Field[] field = model.getClass().getDeclaredFields(); //获取实体类的所有属性，返回Field数组
    for(int j=0 ; j<field.length ; j++){ //遍历所有属性
        String name = field[j].getName(); //获取属性的名字
 
        System.out.println("attribute name:"+name);
        name = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
        String type = field[j].getGenericType().toString(); //获取属性的类型
        if(type.equals("class java.lang.String")){ //如果type是类类型，则前面包含"class "，后面跟类名
          ...
        }
        if(type.equals("class java.lang.Integer")){
          ...
        }
        if(type.equals("class java.lang.Short")){
          ...
        }
        if(type.equals("class java.lang.Double")){
          ...
        }
        if(type.equals("class java.lang.Boolean")){
          ...
        }
        if(type.equals("class java.util.Date")){
          ...
        }
    }
}
```

instanceof： 主要用来判断  对象与类之间的关系。
getclass： 获取运行时期对象的类。
当限定到具体某一类时，则使用getclass+equals搭配

```java

 @Override
    public int compareTo(ComparableRectangle o) {
        if (getArea() > o.getArea()) {
            return 1;
        } else if (getArea() < o.getArea()) {
            return -1;
        } else
            return 0;
    }
    @Override
    public boolean equals(Object o) {//参数不能写当前类
        if (this == o) return true;
        if(o==null||getClass()!=o.getClass()) return false;//getClass获取运行时类
        ComparableRectangle other=(ComparableRectangle)o;//强制转换
        return getWidth() == other.getWidth() && getHeight() == other.getHeight();
    }
    @Override
    public int hashCode() {
        return  (int)(Double.doubleToLongBits(getHeight())+31*Double.doubleToLongBits(getWidth()));//不能添加date，会导致同一对象的hashcode发生变化
    }    

```

Object类中定义clone的方法头是：protected native Object clone() throws CloneNotSupportException;

native表明这个方法不是用java写的，是JVM针对本地平台实现的，不能定义在接口中.

protected 是因为不是每个对象都可以被克隆，Java的设计者强制要实现的子类重写该方法

```java
@Override
    public Object clone() {
        try {
            return super.clone();// 调用父类克隆(浅拷贝)，会沿着调用链到达Object
        } catch (CloneNotSupportedException e) {//也可以选择抛出
            return null;
        }
    }

    public CloneableRectangle deepClone() {//自定义深拷贝，也可重写原浅拷贝
        CloneableRectangle clone = (CloneableRectangle) clone();  //直接调用定义的浅拷贝 ，免去异常检测     
        if(clone != null){
            clone.setDateCreated((java.util.Date)getDateCreated().clone());
        }
        return clone;
    }
```