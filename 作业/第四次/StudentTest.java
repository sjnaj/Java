
/**
 * @Author: fengsc
 * @Date: 2022-04-12 08:43:47
 * @LastEditTime: 2022-04-12 17:30:12
 */
import java.util.*;

class Student {
    private String studentNumber = "";
    private String studentName = "";
    private int markForMaths =-1;
    private int markForEnglish = -1;
    private int markForScience = -1;

    Student() {
    }

    Student(String studentNumber, String studentName) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
    }

    public String getName() {
        return studentName;
    }

    public String getNumber() {
        return studentNumber;
    }

    public void enterMarks(int markForMaths, int markForEnglish, int markForScience) {
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
        return (markForMaths + markForEnglish + markForScience)/3.0;
    }

    @Override
    public String toString() {
        return "Student ID:" + studentNumber + "\nName:" + studentName + "\nMath:" + markForMaths + "\nEnglish:"
                + markForEnglish + "\nScience:" + markForScience + "\nAverage Score:" + String.format("%.1f",calculateAverage());
    }
}




public class StudentTest{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Student student = new Student(input.next(),input.next());
        student.enterMarks(input.nextInt(), input.nextInt(), input.nextInt());
        System.out.println(student);
    }
}