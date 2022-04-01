/**
 * @Author: fengsc
 * @Date: 2022-03-30 20:33:03
 * @LastEditTime: 2022-03-30 21:13:28
 */
package applicator;

public class Applicator {
    public static void apply(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}