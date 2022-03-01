/*
 * @Author: fengsc
 * @Date: 2022-02-22 19:42:01
 * @LastEditTime: 2022-02-24 21:21:25
 */
public class _double {// 防止标识符冲突

    public static void main(String[] args) {

        // 在 Double 类中包含了很多常量，其中较为常用的常量如下。

        // MAX_VALUE:值为 1.8E308 的常量，它表示 double 类型的最大正有限值的常量。
        // MIN_VALUE：值为 4.9E-324 的常量，它表示 double 类型数据能够保持的最小正非零值的常量。
        // NaN：保存 double 类型的非数字值的常量。  
        // NEGATIVE_INFINITY：保持 double 类型的负无穷大的常量。
        // POSITIVE_INFINITY：保持 double 类型的正无穷大的常量。
        // SIZE：以二进制补码形式表示 double 值的比特位数。
        // TYPE：表示基本类型 double 的 Class 实例。
        
        System.out.println(Double.isNaN(0/0.0));//*true(分母为0会报错)
        System.out.println(new Double(0/0.0).isNaN());//*用于Double对象，不能用于double
        System.out.println(Double.isInfinite(Double.MIN_VALUE));//false
    

    }

}
