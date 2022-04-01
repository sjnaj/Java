/**
 * @Author: fengsc
 * @Date: 2022-03-28 15:03:26
 * @LastEditTime: 2022-03-28 15:30:27
 */
public class SpaceShip extends SpaceShipControls {
    private String name;

    public SpaceShip(String name) {
        this.name = name;
    }

    public String toString() {
        return "name:"+name+"\nvelocityX:"+velocityX+"\nvelocityY:"+velocityY+"\nvelocityZ:"+velocityZ+"\nvelocityTurbo:"+velocityTurbo;
    }
    public static void main(String[] args) {
        SpaceShip protector = new SpaceShip("protector");
        protector.forward(100);
        System.out.println(protector);
    }

}