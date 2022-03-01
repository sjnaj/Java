
/*
 * @Author: fengsc
 * @Date: 2022-02-21 21:21:17
 * @LastEditTime: 2022-02-21 23:56:07
 */
import java.util.Date;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    public Loan() {// *java函数没有默认参数，通过调用完整的构造函数实现
        this(2.5, 1, 1000);
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment() {// *等额本息（推导见百度）
        double monthInterestRate = annualInterestRate / 1200;
        return loanAmount * monthInterestRate / (1 - 1 / Math.pow(1 + monthInterestRate, numberOfYears * 12));
    }

    public double getTotalPayment() {
        return getMonthlyPayment() * 12 * numberOfYears;
    }

    public Date getLoanDate() {
        return loanDate;
    }
}