package primerContent;

public class ComplexNumber {

    public float real;
    public float imaginary;

    // Define constructor here
    ComplexNumber(float real, float imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public String toString()
    {
        return this.real+" +"+this.imaginary+"i";
    }

    public ComplexNumber add(ComplexNumber x) {
        // Complete the function
        float i = this.real + x.real;
        float j = this.imaginary + x.imaginary;
        ComplexNumber t = new ComplexNumber(i, j);
        return t;
    }

    public ComplexNumber subtract(ComplexNumber x) {
        // Complete the function
        float i = this.real - x.real;
        float j = this.imaginary - x.imaginary;
        ComplexNumber t = new ComplexNumber(i, j);
        return t;
    }

    public ComplexNumber multiply(ComplexNumber x) {
        // Complete the function
        float i = this.real * x.real;
        float j = this.imaginary * x.imaginary;
        ComplexNumber t = new ComplexNumber(i, j);
        return t;
    }

    public ComplexNumber divide(ComplexNumber x) {
        // Complete the function
        float i = this.real / x.real;
        float j = this.imaginary / x.imaginary;
        ComplexNumber t = new ComplexNumber(i, j);
        return t;
    }


    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(10, 5);
        ComplexNumber b = new ComplexNumber(2, 3);
        ComplexNumber c1 = a.add(b);
        System.out.println(c1);
        ComplexNumber c2 = a.subtract(b);
        System.out.println(c2);
        ComplexNumber c3 = a.multiply(b);
        System.out.println(c3);
        ComplexNumber c4 = a.divide(b);
        System.out.println(c4);
    }
}
