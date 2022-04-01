/**
 * @Author: fengsc
 * @Date: 2022-03-29 21:41:54
 * @LastEditTime: 2022-03-30 11:12:35
 */
class Shared {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared() {
        System.out.println("Creating " + this);
    }

    public void addref() {
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0) {
            System.out.println("Disposing " + this);

        }
    }
    protected void finalize(){
        if(refcount != 0){
            System.out.println("Error :"+this+"has no dispose");
        }
        else System.out.println(this+"disposed successfully");
    }

    public String toString() {
        return "Shared" + id;
    }

}

class Composing {
    private Shared shared;

    private static long counter = 0;

    private final long id = counter++;

    Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addref();
    }

    protected void dispose() {
        System.out.println("Disposing " + this);
        shared.dispose();
    }

    public String toString() {
        return "Composing" + id;
    }
}

public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = { new Composing(shared), new Composing(shared) , new Composing(shared), new Composing(shared),
                new Composing(shared), };
        for(Composing c:composing) {
            c.dispose();
        }
        System.gc();//不一定会被调用(没见过被调用的);
        shared.finalize();//只有手动才会被调用
    }
}
// Creating Shared0
// Creating Composing0
// Creating Composing1
// Creating Composing2
// Creating Composing3
// Creating Composing4
// Disposing Composing0
// Disposing Composing1
// Disposing Composing2
// Disposing Composing3
// Disposing Composing4
// Disposing Shared0//*所有引用解除后销毁