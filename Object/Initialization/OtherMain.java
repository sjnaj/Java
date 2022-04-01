/**
 * @Author: fengsc
 * @Date: 2022-03-26 18:38:34
 * @LastEditTime: 2022-03-26 18:51:33
 */
public class OtherMain {
    public static void main(String[] args) {
        Other.main(new String[] { "fiddle", "de", "dum" });//构造临时数组传参
    }

}

class Other {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
