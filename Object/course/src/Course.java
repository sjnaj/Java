import edu.princeton.cs.algs4.ST;

/*
 * @Author: fengsc
 * @Date: 2022-02-22 00:05:19
 * @LastEditTime: 2022-02-22 00:42:16
 */
public class Course {
    private String courseName;
    private String[] students = new String[50];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        if (numberOfStudents > 49)// 扩容
        {
            String[] temp = new String[numberOfStudents * 2];
            System.arraycopy(student, 0, temp, 0, numberOfStudents);
            numberOfStudents *= 2;
        }
        students[numberOfStudents++] = student;
    }

    public String[] getStudents() {
        String[] studentsCopy = new String[numberOfStudents];
        System.arraycopy(students, 0, studentsCopy, 0, numberOfStudents);
        return studentsCopy;// 返回拷贝防止被外部修改
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        int i;
        for (i = 0; i < numberOfStudents; i++)
            if (students[i] == student) {
                while (i < numberOfStudents - 1)
                    students[i] = students[i++];
                numberOfStudents--;
                System.out.println("Student " + student + "has been dropped successfully");
                return;
            }
        System.out.println("Student " + student + "do not exists");

    }

    public void clear() {
        numberOfStudents=0;
        students = null;
    }

}
