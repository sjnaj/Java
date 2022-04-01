/**
 * @Author: fengsc
 * @Date: 2022-03-30 17:34:02
 * @LastEditTime: 2022-03-30 17:36:23
 */
package interfaces;

interface InterfaceWithDefault {
    void firstMethod();

    void secondMethod();

    default void newMethod() {
        System.out.println("newMethod");
    }
}
