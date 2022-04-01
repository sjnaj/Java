/**
 * @Author: fengsc
 * @Date: 2022-03-30 21:10:20
 * @LastEditTime: 2022-03-30 21:14:51
 */
package applicator;

import java.util.*;

interface StringProcessor extends Processor {
    @Override
    String process(Object input);

    String S = "If she weighs the same as a duck, she's made of wood";

    static void main(String[] args) {
        Applicator.apply(new Upcase(), S);
        Applicator.apply(new Downcase(), S);
        Applicator.apply(new Splitter(), S);
    }

}

class Upcase implements StringProcessor {
    // 返回协变类型
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase implements StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter implements StringProcessor {
@Override
    public String process(Object input) {
    return Arrays.toString(((String) input).split(" "));
    }
}
// Using Processor Upcase
// IF SHE WEIGHS THE SAME AS A DUCK, SHE'S MADE OF WOOD
// Using Processor Downcase
// if she weighs the same as a duck, she's made of wood
// Using Processor Splitter
// [If, she, weighs, the, same, as, a, duck,, she's, made, of, wood]