/**
 * @Author: fengsc
 * @Date: 2022-03-30 18:24:45
 * @LastEditTime: 2022-03-30 18:25:50
 */
package operations;

public interface Operations {
    void execute();

    static void runOps(Operations... ops) {
        for (Operations op : ops) {
            op.execute();
        }
    }

    static void show(String msg) {
        System.out.println(msg);
    }

}
