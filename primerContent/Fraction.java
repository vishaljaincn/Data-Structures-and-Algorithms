package primerContent;

public class Fraction {
    int numerator, denominator;

    // Define constructor here
    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    Fraction add(Fraction a) {
        // Complete the function
        int newNumerator = (this.numerator * a.denominator) + (this.denominator * a.numerator);
        int newDenominator = this.denominator * a.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    Fraction subtract(Fraction a) {
        // Complete the function
        int newNumerator = (this.numerator * a.denominator) - (this.denominator * a.numerator);
        int newDenominator = this.denominator * a.denominator;
        return new Fraction(newNumerator, newDenominator);

    }

    Fraction multiply(Fraction a) {
        // Complete the function
        int newNumerator = this.numerator * a.numerator;
        int newDenominator = this.denominator * a.denominator;
        return new Fraction(newNumerator, newDenominator);

    }

    public static void main(String[] args) {
        Fraction x = new Fraction(2, 3);  // 2/3
        Fraction y = new Fraction(4, 5); // 4/5
        Fraction i = x.add(y); // 22/15
        System.out.println(i.numerator+"/"+ i.denominator);
        Fraction z = x.subtract(y); // -2/15
        System.out.println(z.numerator+"/"+z.denominator);
        Fraction p = x.multiply(y); // 8/15
        System.out.println(p.numerator+"/"+ p.denominator);
    }
}


