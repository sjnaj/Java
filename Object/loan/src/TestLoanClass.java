/*
 * @Author: fengsc
 * @Date: 2022-02-21 21:14:17
 * @LastEditTime: 2022-02-21 22:54:07
 */
import java.util.Scanner;
public class TestLoanClass {
public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter annual interest rate for example, 8.25 :");
    double annualInterestRate =input.nextDouble();
    System.out.println("Enter number of years as an interger:");
    int numberOfYears = input.nextInt();
    System.out.println("Enter loan amount, for example, 120000.95");
    double loanAmount = input.nextDouble();
    Loan loan=new Loan(annualInterestRate,numberOfYears,loanAmount);//*运行时javac后面要加上另一个文件，调试时先将src文件夹加入java目录
    System.out.printf("The loan was created on %s\n"+"The monthly payment is %.2f\nThe total payment is %.2f\n",
    loan.getLoanDate().toString(),loan.getMonthlyPayment(),loan.getTotalPayment());
}
}
