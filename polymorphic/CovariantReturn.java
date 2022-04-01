/**
 * @Author: fengsc
 * @Date: 2022-03-30 12:01:44
 * @LastEditTime: 2022-03-30 12:21:04
 */
//协变返回，允许重写函数返回对应基类函数返回值的导出类
class Grain {
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    public String toString() {
        return "Wheat";
    }
}

class Mill {

    Grain process() {
        return new Grain();
    }

    int process(int i) {
        return 1;
    }
}

class WheatMill extends Mill {
    @Override
    Wheat process() {
        return new Wheat();
    }
}

public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new WheatMill();
        System.out.println(m.process());//Wheat
    }

}
