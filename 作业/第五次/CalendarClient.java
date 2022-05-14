
/**
 * @Author: fengsc
 * @Date: 2022-04-25 14:45:41
 * @LastEditTime: 2022-04-26 08:14:12
 */
import java.util.Calendar;
import java.util.Scanner;

public class CalendarClient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        cal.set(input.nextInt(), input.nextInt() - 1, 1);// 注意减一
        int blacks = cal.get(Calendar.DAY_OF_WEEK) - 2;
        if (blacks < 0)
            blacks = 6;// 第一天是Sun
        System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 0; i < blacks * 4; i++) {
            System.out.print(" ");
        }
        int i;
        for (i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            System.out.printf("%4d", i);
            if ((i + blacks) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        input.close();
    }

}
