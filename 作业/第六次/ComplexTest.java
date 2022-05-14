
/**
 * @Author: fengsc
 * @Date: 2022-05-14 22:02:31
 * @LastEditTime: 2022-05-14 23:57:30
 */
import java.util.Scanner;
class Complex {
    private double x;
    private double y;

    public Complex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Complex add(Complex C) {
        return new Complex(this.x + C.x, this.y + C.y);
    }

    public Complex sub(Complex C) {
        return new Complex(this.x - C.x, this.y - C.y);
    }

    public Complex mul(Complex C) {
        return new Complex(this.x * C.x - this.y * C.y, this.x * C.y + this.y * C.x);
    }

    public Complex div(Complex C) throws ComplexDivException {
        double denominator = C.x * C.x + C.y * C.y;
        if (denominator == 0) {
            throw new ComplexDivException("Error No : 1001\nError Message : Divide by zero.");
        }
        return new Complex((this.x * C.x + this.y * C.y)/denominator,(this.y * C.x-this.x*C.y) / denominator);
    }

    public String toString() {
        return String.format("%.1f%+.1fi", this.x, this.y);
    }
}


class ComplexDivException extends Exception {
    public ComplexDivException(String message) {
        super(message);
    }
}


public class ComplexTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String cmd = input.next();
        int count = input.nextInt();
        while (count-- != 0) {
            Complex a = new Complex(input.nextDouble(), input.nextDouble());
            Complex b = new Complex(input.nextDouble(), input.nextDouble());
            switch (cmd) {
                case "add":
                    System.out.println(a.add(b));
                    break;
                case "sub":
                    System.out.println(a.sub(b));
                    break;
                case "mul":
                    System.out.println(a.mul(b));
                    break;
                case "div":
                    try {
                        System.out.println(a.div(b));
                        
                    } catch (ComplexDivException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        }
    }

}
