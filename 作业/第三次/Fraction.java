
/**
 * @Author: fengsc
 * @Date: 2022-03-28 15:50:10
 * @LastEditTime: 2022-03-29 19:08:33
 */
import java.util.Scanner;

public class Fraction {
    int numerator;
    int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction simplify() {
        int n = Math.abs(numerator), m =Math.abs(denominator);
        int sign=(double)numerator/denominator<0?-1:1;
        int temp, r;

        if (n < m) {
            temp = n;
            n = m;
            m = temp;
        }
        while (m != 0) {
            r = n % m;
            n = m;
            m = r;
        }
        
        return new Fraction(sign*Math.abs(numerator) / n, Math.abs(denominator) / n);
    }

    public Fraction add(Fraction Fraction) {
        return new Fraction(numerator * Fraction.denominator + denominator * Fraction.numerator,
                denominator * Fraction.denominator);
    }

    public Fraction subtract(Fraction Fraction) {
        return add(new Fraction(-Fraction.numerator, Fraction.denominator));
    }

    public Fraction multiply(Fraction Fraction) {
        return new Fraction(numerator * Fraction.numerator, denominator * Fraction.denominator);
    }

    public Fraction divide(Fraction Fraction) {
        return multiply(Fraction.inverse());
    }

    public Fraction inverse() {
        return new Fraction(denominator, numerator);
    }

    public String toString() {
         Fraction temp = simplify();
         
        
        return temp.numerator + "/" + temp.denominator + "\n";// 注意加换行简化输出
    }

    public String getDecimal() {
        return String.format("%.1f", (double)numerator / denominator);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt(), m1 = input.nextInt(), n2 = input.nextInt(), m2 = input.nextInt();
        Fraction a = new Fraction(n1, m1);
        Fraction b = new Fraction(n2, m2);
        System.out.println(
                "" + a + b + a.add(b) + a.subtract(b) + a.multiply(b) + a.divide(b) + a.inverse() + a.getDecimal());
    }
}