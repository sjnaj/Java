/**
 * @Author: fengsc
 * @Date: 2022-03-30 20:51:53
 * @LastEditTime: 2022-03-30 20:55:21
 */
package filters;

public class LowPass  extends Filter{
    double cutoff;
    public LowPass(double cutoff){this.cutoff = cutoff;}    
    @Override
    public Waveform process(Waveform input){
        return input;
    }
}