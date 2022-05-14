
/**
 * @Author: fengsc
 * @Date: 2022-04-12 09:03:03
 * @LastEditTime: 2022-05-14 21:56:42
 */
import java.util.*;

class StudentList {
    ArrayList<Student> list = new ArrayList<>(10);

    public boolean add(Student student) {
        if (getItem(student.getNumber()) == null)
            return list.add(student);
        return false;
    }

    public boolean remove(String number) {
        return list.remove(getItem(number));
    }

    public boolean updateItem(String number, int math, int english, int science) {
        Student stu;
        if ((stu = getItem(number)) == null)
            return false;
        stu.enterMarks(math, english, science);
        return true;
    }

    public Student getItem(String number) {
        for (Student student : list) {
            if (student.getNumber().equals(number)) {
                return student;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    int getTotal() {
        return list.size();
    }
}

public class StudentListTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentList list = new StudentList();
        Student stu;
        int cnt = input.nextInt();
        while (cnt-- != 0)
            switch (input.nextInt()) {
                case 1:
                    stu = new Student(input.next(), input.next());
                    stu.enterMarks(input.nextInt(), input.nextInt(), input.nextInt());
                    if (list.add(stu) == true)
                        System.out.println("Add success");
                    else
                        System.out.println("Students already exist");
                    break;
                case 2:
                    if (list.remove(input.next()))
                        System.out.println("Delete success");
                    else
                        System.out.println("Students do not exist");
                    break;
                case 3:
                    if (list.updateItem(input.next(), input.nextInt(), input.nextInt(), input.nextInt()))
                        System.out.println("Update success");
                    else
                        System.out.println("Students do not exist");
                    break;
                case 4:
                    if ((stu = list.getItem(input.next())) != null)
                        System.out.println(
                                "Student ID:" + stu.getNumber() + "\nName:" + stu.getName() + "\nAverage Score:"
                                        + String.format("%.1f", stu.calculateAverage()));
                    else
                        System.out.println("Students do not exist");
                    break;
                case 5:
                    if (list.isEmpty())
                        System.out.println("List is empty");
                    else
                        System.out.println("List is not empty");
                    break;
                case 6:
                    System.out.println(list.getTotal());
                    break;
                default:
                    break;
            }
    }
}
