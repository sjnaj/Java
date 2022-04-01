/**
 * @Author: fengsc
 * @Date: 2022-03-30 23:14:25
 * @LastEditTime: 2022-03-30 23:22:24
 */
/*生成符合某个接口的对象的典型方式是工厂方法设计模
式。不同于直接调用构造器，只需调用工厂对象中的创建方法就能生成对象的实现——
理论上，通过这种方式可以将接口与实现的代码完全分离，使得可以透明地将某个实现替换为另一个实现。*/
package factories;

interface Game {
    boolean move();

}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {
    private int moves = 0;
    private static final int MOVES = 3;

    @Override
    public boolean move() {// *注意访问权限符public，忽略会因为低于接口的默认public而报错
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }
}

class CheckersFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Checkers();
    }

}

class Chess implements Game {
    private int moves = 0;
    private static final int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }
}

class ChessFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Chess();
    }
}

public class Games {
    public static void playGame(GameFactory factory) {
        Game s = factory.getGame();
        while (s.move())
            ;
    }

    public static void main(String[] args) {
        playGame(new CheckersFactory());
        playGame(new ChessFactory());
    }
}
// Checkers move 0
// Checkers move 1
// Checkers move 2
// Chess move 0
// Chess move 1
// Chess move 2
// Chess move 3