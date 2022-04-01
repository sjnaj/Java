/**
 * @Author: fengsc
 * @Date: 2022-03-28 15:20:59
 * @LastEditTime: 2022-03-28 15:30:05
 */
public class SpaceShipDelegation {
    private String name;
    private SpaceShipControls controls = new SpaceShipControls();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    public void backward(int velocity) {
        controls.backward(velocity);
    }

    public void forward(int velocity) {
        controls.forward(velocity);
    }

    public void left(int velocity) {
        controls.left(velocity);
    }

    public void right(int velocity) {
        controls.right(velocity);
    }

    public void up(int velocity) {
        controls.up(velocity);
    }

    public void down(int velocity) {
        controls.down(velocity);
    }

    // public void turboBoost(int velocity) {
    //     controls.turboBoost(velocity);
    // }
        //代理模式可以选择要暴露的方法，本例隐藏turboBoost方法
    public static void main(String[] args) {
        SpaceShipDelegation protector = new SpaceShipDelegation("protector");
        protector.forward(100);
    }
}
