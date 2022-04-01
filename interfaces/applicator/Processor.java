/**
 * @Author: fengsc
 * @Date: 2022-03-30 21:08:24
 * @LastEditTime: 2022-03-30 21:08:24
 */
package applicator;

public interface Processor {
    default String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input);

}