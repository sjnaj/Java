/**
 * @Author: fengsc
 * @Date: 2022-04-25 14:16:22
 * @LastEditTime: 2022-04-25 14:35:30
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Timeformat {
    public static void main(String[] args) {

        String date = null;

        try (Scanner input = new Scanner(System.in);) {

            LocalDate parsedDate =
                    LocalDate.parse(input.next(), DateTimeFormatter.ofPattern(input.next()));
            date = parsedDate.format(DateTimeFormatter.ofPattern(input.next()));
        } catch (DateTimeParseException e) {
            System.out.println("Text could not be parsed .");
            return;
        }
        System.out.println(date);

    }

}
