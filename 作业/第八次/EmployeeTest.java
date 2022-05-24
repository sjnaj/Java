/**
 * @Author: fengsc
 * @Date: 2022-05-24 11:01:44
 * @LastEditTime: 2022-05-24 12:37:12
 */
import java.util.*;

abstract class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    @Override
    public int compareTo(Employee other) {
        return Double.compare(earning(), other.earning());
    }

    abstract double earning();

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    @Override
    public String toString() {
        return "firstName:" + firstName + "; lastName:" + lastName + "; socialSecurityNumber:"
                + socialSecurityNumber + "; earning:" + String.format("%.2f", earning());
    }

}


class SalaridEmployee extends Employee {
    public SalaridEmployee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    private double weeklySalary;

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double earning() {
        return weeklySalary * 4;
    }

}


class HourlyEmployee extends Employee {
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    private double wage;
    private double hours;

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public double earning() {
        return wage * hours;
    }
}


class CommisionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;

    public CommisionEmployee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public double earning() {
        return grossSales * commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
}


class BasePlusCommisionEmployee extends CommisionEmployee {
    public BasePlusCommisionEmployee(String firstName, String lastName,
            String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    private double baseSalary;

    @Override
    public double earning() {
        return super.earning() + baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}


public class EmployeeTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int memberCount = input.nextInt();
        List<Employee> employees = new ArrayList<Employee>();
        while (memberCount-- != 0) {
            switch (input.nextInt()) {
                case 0:

                    SalaridEmployee employee0 =
                            new SalaridEmployee(input.next(), input.next(), input.next());
                    employee0.setWeeklySalary(input.nextDouble());
                    employees.add(employee0);
                    break;
                case 1:
                    HourlyEmployee employee1 =
                            new HourlyEmployee(input.next(), input.next(), input.next());
                    employee1.setWage(input.nextDouble());
                    employee1.setHours(input.nextDouble());
                    employees.add(employee1);
                    break;
                case 2:
                    CommisionEmployee employee2 =
                            new CommisionEmployee(input.next(), input.next(), input.next());
                    employee2.setGrossSales(input.nextDouble());
                    employee2.setCommissionRate(input.nextDouble());
                    employees.add(employee2);
                    break;
                case 3:
                    BasePlusCommisionEmployee employee3 =
                            new BasePlusCommisionEmployee(input.next(), input.next(), input.next());
                    employee3.setGrossSales(input.nextDouble());
                    employee3.setCommissionRate(input.nextDouble());
                    employee3.setBaseSalary(input.nextDouble());
                    employees.add(employee3);
                    break;

            }
        }
        Collections.sort(employees);
        int orderCount = input.nextInt();
        while (orderCount-- != 0) {
            if (input.nextInt() == 0) {
                String name = input.next();
                for (Employee employee : employees) {
                    if (employee.getFirstName().equals(name)) {
                        System.out.println(employee);
                    }
                }
            } else {
                String Number = input.next();
                for (Employee employee : employees) {
                    if (employee.getSocialSecurityNumber().equals(Number)) {
                        System.out.println(employee);
                    }
                }
            }
        }
        input.close();
    }

}
