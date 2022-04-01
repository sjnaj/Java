/**
 * @Author: fengsc
 * @Date: 2022-03-30 20:48:34
 * @LastEditTime: 2022-03-30 20:57:48
 */
package filters;

public class Waveform {
    private static long counter;
    private final long id = counter++;
    @Override
    public String toString() {
        return "WavaForm"+ id;
    }
    
}
