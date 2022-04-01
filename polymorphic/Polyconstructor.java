/**
 * @Author: fengsc
 * @Date: 2022-03-30 11:44:37
 * @LastEditTime: 2022-03-30 11:50:37
 */
class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

public class Polyconstructor {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
// Glyph() before draw()
// RoundGlyph.draw(), radius = 0//*首先调用基类构造器时调用了导出类的draw，此时内存被置零，所以得到0
//*因此要防止基类构造器访问到未被初始化的导出类的域,如果可能，应在基类构造器中不访问除final方法外的方法
// Glyph() after draw()
// RoundGlyph.RoundGlyph(), radius = 5