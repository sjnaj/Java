/**
 * @Author: fengsc
 * @Date: 2022-03-31 10:48:53
 * @LastEditTime: 2022-03-31 11:07:56
 */
package innerclasses;
//在任意作用域嵌入一个类
public class Parcel3 {
    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        p.track();
    }

}
