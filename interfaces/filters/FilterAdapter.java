/**
 * @Author: fengsc
 * @Date: 2022-03-30 21:16:08
 * @LastEditTime: 2022-03-30 22:15:07
 */
package filters;
import applicator.Processor;
class FilterAdapter implements Processor{
    Filter filter;
    FilterAdapter(Filter filter){
        this.filter = filter;
    }
    @Override
    public String name(){
        return filter.name();
    }
    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }

    
}
