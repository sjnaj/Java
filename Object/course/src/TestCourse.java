/*
 * @Author: fengsc
 * @Date: 2022-02-21 23:58:32
 * @LastEditTime: 2022-02-22 00:46:44
 */
public class TestCourse {
    public static void main(String[] args) {
        Course course1 = new Course("Date Structure");
        Course course2 = new Course("Datebase System");
        course1.addStudent("Peter Jones");
        course1.addStudent("Kim Smith");
        course1.addStudent("Anna Kennedy");
        course2.addStudent("Peter Jones");
        course2.addStudent("Steve Smith");

        System.out.println("Number of students in course1: " + course1.getNumberOfStudents());
        String[] students = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudents(); i++) {
            System.out.println(students[i] + ',');
        }
        System.out.println();
        System.out.println("Number of students in course2: " + course2.getNumberOfStudents());

        course1.dropStudent("lala");
        course1.dropStudent("Peter Jones");
        course2.clear();
        System.out.println("Number of students in course1: " + course1.getNumberOfStudents());

        System.out.println("Number of students in course2: " + course2.getNumberOfStudents());
    }

}
