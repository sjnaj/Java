/*
 * @Author: fengsc
 * @Date: 2022-03-21 23:49:04
 * @LastEditTime: 2022-03-22 09:26:51
 */
import java.util.Arrays;
public class ComparableRectangle extends geometry.Rectangle implements Comparable<ComparableRectangle> {
    public ComparableRectangle(double width, double height) {
        super(width, height);
    }

    @Override
    public int compareTo(ComparableRectangle o) {
        if (getArea() > o.getArea()) {
            return 1;
        } else if (getArea() < o.getArea()) {
            return -1;
        } else
            return 0;
    }
    @Override
    public boolean equals(Object o) {//参数不能写当前类
        if (this == o) return true;
        if(o==null||getClass()!=o.getClass()) return false;//getClass获取运行时类
        ComparableRectangle other=(ComparableRectangle)o;//强制转换
        return getWidth() == other.getWidth() && getHeight() == other.getHeight();
    }
    @Override
    public int hashCode() {
        return  (int)(Double.doubleToLongBits(getHeight())+31*Double.doubleToLongBits(getWidth())+31*getDateCreated().getTime());
    }    
    
    
    
   
    
}
