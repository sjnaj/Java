/**
 * @Author: fengsc
 * @Date: 2022-03-30 20:50:18
 * @LastEditTime: 2022-03-30 21:15:51
 */
package filters;
import applicator.Applicator;

public class Filter {
    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }


}