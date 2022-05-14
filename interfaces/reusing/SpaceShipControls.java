/**
 * @Author: fengsc
 * @Date: 2022-03-28 15:04:04
 * @LastEditTime: 2022-03-28 15:22:38
 */
public class SpaceShipControls {
    protected int velocityX=0;
    protected int velocityY=0;
    protected int velocityZ=0;
    protected int velocityTurbo=0;
    void up(int velocity){velocityZ=velocity;}
    void down(int velocity){velocityZ=-velocity;}
    void left(int velocity){velocityY=velocity;}
    void right(int velocity){velocityY=-velocity;}
    void forward(int velocity){velocityX=velocity;}
    void backward(int velocity){velocityX=-velocity;}
    void turboBoost(int velocity){velocityTurbo=velocity;}
    
}


