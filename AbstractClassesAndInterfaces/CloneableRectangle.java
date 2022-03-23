/*
 * @Author: fengsc
 * @Date: 2022-03-22 09:51:10
 * @LastEditTime: 2022-03-22 10:18:17
 */

public class CloneableRectangle extends ComparableRectangle implements Cloneable {// Cloneableo没有参数
    // !继承ComparableRectanle的Comparable等方法
    public CloneableRectangle(double width, double height) {
        super(width, height);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();// 调用父类克隆(浅拷贝)，会沿着调用链到达Object
        } catch (CloneNotSupportedException e) {//也可以选择抛出
            return null;
        }
    }

    public CloneableRectangle deepClone() {//自定义深拷贝，也可重写原浅拷贝
        CloneableRectangle clone = (CloneableRectangle) clone();  //直接调用定义的浅拷贝 ，免去异常检测     
        if(clone != null){
            clone.setDateCreated((java.util.Date)getDateCreated().clone());
        }
        return clone;
    }

}
