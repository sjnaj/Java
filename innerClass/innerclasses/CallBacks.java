/**
 * @Author: fengsc
 * @Date: 2022-03-31 18:11:46
 * @LastEditTime: 2022-03-31 20:42:33
 */
package innerclasses;

interface Incrementable {
    void increment();

}

class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    void increment() {
        System.out.println("Other Options");
    }

}

class Callee2 extends MyIncrement {// 继承了MyIncrement就不能实现接口，因为函数签名冲突
    private int i = 0;

    @Override
    void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Incrementable {// 通过内部类实现接口，并使重写的两个increment实现相同
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementable getCallbackReference() {
        return new Closure();
    }
}

class Caller {
    private Incrementable callBackReference;

    Caller(Incrementable callBackReference) {
        this.callBackReference = callBackReference;
    }

    void go() {
        callBackReference.increment();
    }
}

public class CallBacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        c1.increment();
        c2.increment();
        caller1.go();
        caller2.go();

    }

}
