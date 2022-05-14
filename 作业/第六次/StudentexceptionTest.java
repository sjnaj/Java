
/**
 * @Author: fengsc
 * @Date: 2022-05-14 21:38:43
 * @LastEditTime: 2022-05-14 22:01:13
 */

import java.util.*;
import java.util.regex.*;

class Student1 {
    private String studentNumber = "";
    private String studentName = "";
    private int markForMaths = -1;
    private int markForEnglish = -1;
    private int markForScience = -1;

    Student1() {}

    Student1(String studentNumber, String studentName) throws StudentNumberException {

        if (studentNumber.length()!=10||!Pattern.matches("20\\d+", studentNumber)) {
            throw new StudentNumberException("Illegal number format");
        }
        this.studentNumber = studentNumber;
        this.studentName = studentName;
    }

    public String getName() {
        return studentName;
    }

    public String getNumber() {
        return studentNumber;
    }

    public void enterMarks(int markForMaths, int markForEnglish, int markForScience)
            throws ScoreException {
        if (markForMaths < 0 || markForEnglish < 0 || markForScience < 0 || markForMaths > 100
                || markForEnglish > 100 || markForScience > 100) {
            throw new ScoreException("Illegal score format");
        }
        this.markForMaths = markForMaths;
        this.markForEnglish = markForEnglish;
        this.markForScience = markForScience;
    }

    public int getMathsMark() {
        return markForMaths;
    }

    public int getEnglishMark() {
        return markForEnglish;
    }

    public int getScienceMark() {
        return markForScience;
    }

    public double calculateAverage() {
        return (markForMaths + markForEnglish + markForScience) / 3.0;
    }

    @Override
    public String toString() {
        return "Student ID:" + studentNumber + "\nName:" + studentName + "\nMath:" + markForMaths
                + "\nEnglish:" + markForEnglish + "\nScience:" + markForScience + "\nAverage Score:"
                + String.format("%.1f", calculateAverage());
    }
}


class ScoreException extends Exception {
    public ScoreException(String message) {
        super(message);
    }
}


class StudentNumberException extends Exception {
    public StudentNumberException(String message) {
        super(message);
    }
}


public class StudentexceptionTest {
    public static void main(String[] args) throws StudentNumberException, ScoreException {
        try (Scanner input = new Scanner(System.in)) {
            Student1 student = new Student1(input.next(), input.next());
            student.enterMarks(input.nextInt(), input.nextInt(), input.nextInt());
            System.out.println(student);
        }catch(StudentNumberException e){
            System.out.println(e.getMessage());
        }catch(ScoreException e){
            System.out.println(e.getMessage());
        }
    }
}
