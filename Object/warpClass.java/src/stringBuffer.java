/*
 * @Author: fengsc
 * @Date: 2022-02-23 13:46:02
 * @LastEditTime: 2022-02-23 18:45:23
 */
public class stringBuffer {
    public static void main(String[] args) {
        // 定义一个空的字符串缓冲区，含有16个字符的容量
        StringBuffer str1 = new StringBuffer();
        // 定义一个含有10个字符容量的字符串缓冲区
        StringBuffer str2 = new StringBuffer(10);
        // 定义一个含有(16+4)的字符串缓冲区，"青春无悔"为4个字符
        StringBuffer str3 = new StringBuffer("青春无悔");
        /*
         * 输出字符串的容量大小
         * capacity()方法返回字符串的容量大小
         */
        System.out.println(str1.capacity()); // 输出 16
        System.out.println(str2.capacity()); // 输出 10
        System.out.println(str3.capacity()); // 输出 20

        {
            StringBuffer buffer = new StringBuffer("Hello,");
            buffer.append("word");
            buffer.append(666);//*添加基本类型
            // *以下三种方式输出相同
            System.out.println(buffer);
            System.out.println(buffer.toString());
            System.out.println(buffer.substring(0));
            
        }
        {
            StringBuffer sb = new StringBuffer("hello");
            sb.setCharAt(1, 'E');
            sb.charAt(-1);
            System.out.println(sb); // 输出：hEllo

            System.out.println(sb.insert(5, "word"));// hElloword

            sb.delete(5, sb.length());

            System.out.println(sb.insert(5, "word", 0, 4));// hElloword

            System.out.println(sb.reverse());// 逆转

        }
        {
            StringBuffer sb = new StringBuffer("hello jack");
            sb.delete(2, 5);
            System.out.println(sb); // 输出：he jack
            sb.deleteCharAt(6);
            System.out.println(sb);// he jac

            sb.setLength(20);//多补零
            sb.trimToSize();
            System.out.println(sb.length()==sb.capacity());//*true
        }
        // String 是 Java 中基础且重要的类，被声明为 final
        // class，是不可变字符串。因为它的不可变性，所以拼接字符串时候会产生很多无用的中间对象，如果频繁的进行这样的操作对性能有所影响。

        // StringBuffer 就是为了解决大量拼接字符串时产生很多中间对象问题而提供的一个类。它提供了 append 和 add
        // 方法，可以将字符串添加到已有序列的末尾或指定位置，它的本质是一个线程安全的可修改的字符序列。

        // 在很多情况下我们的字符串拼接操作不需要线程安全，所以 StringBuilder 登场了。StringBuilder 是 JDK1.5 发布的，它和
        // StringBuffer 本质上没什么区别，就是去掉了保证线程安全的那部分，减少了开销。

        // !使用环境：
        // 操作少量的数据使用 String。
        // 单线程操作大量数据使用 StringBuilder。
        // 多线程操作大量数据使用 StringBuffer。

    }

}
