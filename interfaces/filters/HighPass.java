/**
 * @Author: fengsc
 * @Date: 2022-03-30 20:56:46
 * @LastEditTime: 2022-03-30 20:56:46
 */
package filters;

public class HighPass extends Filter {
    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}