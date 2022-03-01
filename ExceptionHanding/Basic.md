# 异常处理

## 简介

Java 中的异常又称为例外，是一个在程序执行期间发生的事件，它中断正在执行程序的正常指令流。为了能够及时有效地处理程序中的运行错误，必须使用异常类，这可以让程序具有极好的容错性且更加健壮。

在 Java 中一个异常的产生，主要有如下三种原因：

- Java 内部错误发生异常，Java 虚拟机产生的异常。
- 编写的程序代码中的错误所产生的异常，例如空指针异常、数组越界异常等。
- 通过 throw 语句手动生成的异常，一般用来告知该方法的调用者一些必要信息。

```java
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        System.out.println("请输入您的选择：（1~3 之间的整数）");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        switch (num) {
        case 1:
            System.out.println("one");
            break;
        case 2:
            System.out.println("two");
            break;
        case 3:
            System.out.println("three");
            break;
        default:
            System.out.println("error");
            break;
        }
    }
}
```

运行结果：

> 请输入您的选择：（1~3 之间的整数）
a
> > Exception in thread "main" java.util.InputMismatchException
        at java.util.Scanner.throwFor(Unknown Source)
        at java.util.Scanner.next(Unknown Source)
        at java.util.Scanner.nextInt(Unknown Source)
        at java.util.Scanner.nextInt(Unknown Source)
        at text.text.main(text.java:11)

## 异常类型

在 Java 中所有异常类型都是内置类 java.lang.Throwable 类的子类，即 Throwable 位于异常类层次结构的顶层。Throwable 类下有两个异常分支 *Exception 和 Error*。

Throwable 类是所有异常和错误的超类，下面有 Error 和 Exception 两个子类分别表示错误和异常。其中异常类 Exception 又分为**运行时异常和非运行时异常**，这两种异常有很大的区别，也称为不检查异常（Unchecked Exception）和检查异常（Checked Exception）。
    - Exception 类用于用户程序可能出现的异常情况，它也是用来创建自定义异常类型类的类。
    - Error 定义了在通常环境下不希望被程序捕获的异常。一般指的是 JVM 错误，如堆栈溢出。

运行时异常都是 RuntimeException 类及其子类异常，如 NullPointerException、IndexOutOfBoundsException 等，这些异常是不检查异常，程序中可以选择捕获处理，也可以不处理。**这些异常一般由程序逻辑错误引起，程序应该从逻辑角度尽可能避免这类异常的发生**。

非运行时异常是指 RuntimeException 以外的异常，类型上都属于 Exception 类及其子类。**从程序语法角度讲是必须进行处理的异常**，如果不处理，程序就不能编译通过。如 IOException、ClassNotFoundException 等以及用户自定义的 Exception 异常（一般情况下不自定义检查异常）。

<table>
<caption>
表 1 Java中常见运行时异常</caption>
<tbody>
<tr>
<th>
异常类型</th>
<th>
说明</th>
</tr>
<tr>
<td>
ArithmeticException</td>
<td>
算术错误异常，如以零做除数</td>
</tr>
<tr>
<td>
ArraylndexOutOfBoundException</td>
<td>
数组索引越界</td>
</tr>
<tr>
<td>
ArrayStoreException</td>
<td>
向类型不兼容的数组元素赋值</td>
</tr>
<tr>
<td>
ClassCastException</td>
<td>
类型转换异常</td>
</tr>
<tr>
<td>
IllegalArgumentException</td>
<td>
使用非法实参调用方法</td>
</tr>
<tr>
<td>
lIIegalStateException</td>
<td>
环境或应用程序处于不正确的状态</td>
</tr>
<tr>
<td>
lIIegalThreadStateException</td>
<td>
被请求的操作与当前线程状态不兼容</td>
</tr>
<tr>
<td>
IndexOutOfBoundsException</td>
<td>
某种类型的索引越界</td>
</tr>
<tr>
<td>
NullPointerException</td>
<td>
尝试访问 null 对象成员，空指针异常</td>
</tr>
<tr>
<td>
NegativeArraySizeException</td>
<td>
再负数范围内创建的数组</td>
</tr>
<tr>
<td>
NumberFormatException</td>
<td>
数字转化格式异常，比如字符串到 float 型数字的转换无效</td>
</tr>
<tr>
<td>
TypeNotPresentException</td>
<td>
类型未找到</td>
</tr>
</tbody>
</table>

<table>
<caption>
<br>
表 2 Java常见非运行时异常</caption>
<tbody>
<tr>
<th>
异常类型</th>
<th>
说明</th>
</tr>
<tr>
<td>
ClassNotFoundException</td>
<td>
没有找到类</td>
</tr>
<tr>
<td>
IllegalAccessException</td>
<td>
访问类被拒绝</td>
</tr>
<tr>
<td>
InstantiationException</td>
<td>
试图创建抽象类或接口的对象</td>
</tr>
<tr>
<td>
InterruptedException</td>
<td>
线程被另一个线程中断</td>
</tr>
<tr>
<td>
NoSuchFieldException</td>
<td>
请求的域不存在</td>
</tr>
<tr>
<td>
NoSuchMethodException</td>
<td>
请求的方法不存在</td>
</tr>
<tr>
<td>
ReflectiveOperationException</td>
<td>
与反射有关的异常的超类</td>
</tr>
</tbody>
</table>

## 异常处理机制

Java 的异常处理通过 5 个关键字来实现：**try、catch、throw、throws 和 finally**。try catch 语句用于捕获并处理异常，finally 语句用于在任何情况下（除特殊情况外）都必须执行的代码，throw 语句用于拋出异常，throws 语句用于声明可能会出现的异常。

异常处理的机制如下：

- 在方法中用 try catch 语句捕获并处理异常，catch 语句可以有多个，用来匹配多个异常。
- 对于处理不了的异常或者要转型的异常，在方法的声明处通过 throws 语句拋出异常，即由上层的调用方法来处理。

```java
    try {
        逻辑程序块
    } catch(ExceptionType1 e) {
        处理代码块1
    } catch (ExceptionType2 e) {
        处理代码块2
        throw(e);    // 再抛出这个"异常"
    } finally {
        释放资源代码块
    }
```

可以使用以下 3 个方法输出相应的异常信息。

- printStackTrace() 方法：指出异常的类型、性质、栈层次及出现在程序中的位置.
- getMessage() 方法：输出错误的性质。
- toString() 方法：给出异常的类型与性质。

## try catch 语句

使用 try-catch-finally 语句时需注意以下几点：

- 异常处理语法结构中只有 try 块是必需的，也就是说，如果没有 try 块，则不能有后面的 catch 块和 finally 块；
- catch 块和 finally 块都是可选的，但 catch 块和 finally 块至少出现其中之一，也可以同时出现；
- 可以有多个 catch 块，捕获父类异常的 catch 块必须位于捕获子类异常的后面；
- 不能只有 try 块，既没有 catch 块，也没有 finally 块；
- 多个 catch 块必须位于 try 块之后，finally 块必须位于所有的 catch 块之后。
- finally 与 try 语句块匹配的语法格式，此种情况会导致异常丢失，所以不常见。

try catch finally 语句块的执行情况可以细分为以下 3 种情况：

- 如果 try 代码块中没有拋出异常，则执行完 try 代码块之后直接执行 finally 代码块，然后执行 try catch finally 语句块之后的语句。
- 如果 try 代码块中拋出异常，并被 catch 子句捕捉，那么在拋出异常的地方终止 try 代码块的执行，转而执行相匹配的 catch 代码块，之后执行 finally 代码块。如果 finally 代码块中没有拋出异常，则继续执行 try catch finally 语句块之后的语句；如果 finally 代码块中拋出异常，则把该异常传递给该方法的调用者。
- 如果 try 代码块中拋出的异常没有被任何 catch 子句捕捉到，那么将直接执行 finally 代码块中的语句，并把该异常传递给该方法的调用者。

除非在 try 块、catch 块中调用了退出虚拟机的方法*System.exit(int status)*，否则不管在 try 块或者 catch 块中执行怎样的代码，出现怎样的情况，异常处理的 finally 块总会执行。

Java中finally与return的执行顺序,总结为以下几条：

- 当 try 代码块和 catch 代码块中有 return 语句时，finally 仍然会被执行。
- **执行 try 代码块或 catch 代码块中的 return 语句之前，都会先执行 finally 语句**。
- 无论在 finally 代码块中是否修改返回值，返回值都不会改变，仍然是执行 finally 代码块之前的值。
- finally 代码块中的 return 语句会导致程序会提前退出。

## 自动资源管理

当程序使用 finally 块关闭资源时，程序会显得异常臃肿，例如以下代码

```java

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭磁盘文件，回收资源
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

```

Java 7 增加了一个新特性，该特性提供了另外一种管理资源的方式，这种方式能自动关闭文件，被称为自动资源管理（Automatic Resource Management）。该特性是在 try 语句上的扩展，主要释放不再需要的文件或其他资源。

注意：

- try 语句中声明的资源被隐式声明为 final，资源的作用局限于带资源的 try 语句。
- 可以在一条 try 语句中声明或初始化多个资源，每个资源以;隔开即可。
- 需要关闭的资源必须实现了 AutoCloseable 或 Closeable 接口。

```java
    public class AutoCloseTest {
        public static void main(String[] args) throws IOException {
            try (
                    // 声明、初始化两个可关闭的资源
                    // try语句会自动关闭这两个资源
                    BufferedReader br = new BufferedReader(new FileReader("AutoCloseTest.java"));
                    PrintStream ps = new PrintStream(new FileOutputStream("a.txt"))) {
                // 使用两个资源
                System.out.println(br.readLine());
                ps.println("C语言中文网");
            }
        }
    }
```

两个 IO 流，BufferedReader 和 PrintStream 都实现了 Closeable 接口，并在 try 语句中进行了声明和初始化，所以 try 语句会自动关闭它们。

Java 9 再次增强了这种 try 语句。Java 9 不要求在 try 后的圆括号内声明并创建资源，只需要自动关闭的资源有 final 修饰或者是有效的 final (effectively final),Java 9 允许将资源变量放在 try 后的圆括号内。

```java
    public class AutoCloseTest {
        public static void main(String[] args) throws IOException {
            // 有final修饰的资源
            final BufferedReader br = new BufferedReader(new FileReader("AutoCloseTest.java"));
            // 没有显式使用final修饰，但只要不对该变量重新赋值，该变量就是有效的
            final PrintStream ps = new PrintStream(new FileOutputStream("a. txt"));
            // 只要将两个资源放在try后的圆括号内即可
            try (br; ps) {
                // 使用两个资源
                System.out.println(br.readLine());
                ps.println("C语言中文网");
            }
        }
    }
```

## 声明和抛出异常

使用 throws 声明抛出异常的思路是，**当前方法不知道如何处理这种类型的异常**，该异常应该由向上一级的调用者处理；如果 main 方法也不知道如何处理这种类型的异常，也可以使用 throws 声明抛出异常，该异常将交给 JVM 处理。JVM 对异常的处理方法是，打印异常的跟踪栈信息，并中止程序运行

```java
    import java.io.FileInputStream;
    import java.io.IOException;
    public class Test04 {
        public void readFile() throws IOException {
            // 定义方法时声明异常
            FileInputStream file = new FileInputStream("read.txt"); // 创建 FileInputStream 实例对象
            int f;
            while ((f = file.read()) != -1) {
                System.out.println((char) f);
                f = file.read();
            }
            file.close();
        }
        public static void main(String[] args) {
            Throws t = new Test04();
            try {
                t.readFile(); // 调用 readFHe()方法
            } catch (IOException e) {
                // 捕获异常
                System.out.println(e);
            }
        }
    }
```

子类方法声明抛出的异常类型应该是**父类方法声明抛出的异常类型的子类或相同**

```java

    public class OverrideThrows {
        public void test() throws IOException {
            FileInputStream fis = new FileInputStream("a.txt");
        }
    }
    class Sub extends OverrideThrows {
        // 子类方法声明抛出了比父类方法更大的异常
        // 所以下面方法出错
        public void test() throws Exception {
        }
    }
```

**ExceptionObject 必须是 Throwable 类或其子类**的对象。如果是自定义异常类，也必须是 Throwable 的直接或间接子类。

## 多异常捕获

使用一个 catch 块捕获多种类型的异常时需要注意如下两个地方。

- 捕获多种类型的异常时，多种异常类型之间用竖线|隔开。(**父类和子类不能同时出现，统一用父类代表**)
- 捕获多种类型的异常时，**异常变量有隐式的 final 修饰**，因此程序不能对异常变量重新赋值。（单个类型异常没有此限制）

