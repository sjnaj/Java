/**
 * @Author: fengsc
 * @Date: 2022-03-30 18:27:00
 * @LastEditTime: 2022-03-30 19:15:31
 */
package operations;

class Bing implements Operations {
    public void execute() {
        Operations.show("Bing");
    }

}

class Crack implements Operations {
    public void execute() {
        Operations.show("Crack");
    }
}

class Twist implements Operations {
    public void execute() {
        Operations.show("Twist");
    }
}

public class Machines {
    public static void main(String[] args) {
        Operations.runOps(new Bing(), new Crack(), new Twist());// 调用静态方法
    }

}
// Bing
// Crack
// Twist
