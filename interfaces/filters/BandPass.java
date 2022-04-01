/**
 * @Author: fengsc
 * @Date: 2022-03-30 20:58:32
 * @LastEditTime: 2022-03-30 21:00:34
 */
package filters;

public class BandPass extends Filter {
    double lowCutoff, highCutoff;

    public BandPass(double lowCut, double highCut) {
        lowCutoff = lowCut;
        highCutoff = highCut;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }

}
