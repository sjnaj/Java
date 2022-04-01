/**
 * @Author: fengsc
 * @Date: 2022-03-30 22:16:19
 * @LastEditTime: 2022-03-30 22:18:16
 */
package filters;
import applicator.Applicator;
public class FilterProcessor {
    public static void main(String[] args) {
        Applicator.apply(new FilterAdapter(new LowPass(1.0)), new Waveform());
        Applicator.apply(new FilterAdapter(new HighPass(2.0)), new Waveform());
        Applicator.apply(new FilterAdapter(new BandPass(3.0, 4.0)), new Waveform());
    }

}
// Using Processor LowPass
// WavaForm0
// Using Processor HighPass
// WavaForm1
// Using Processor BandPass
// WavaForm2