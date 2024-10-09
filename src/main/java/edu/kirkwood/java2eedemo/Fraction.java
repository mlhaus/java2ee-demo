package edu.kirkwood.java2eedemo;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 1;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if(denominator == 0){
            throw new ArithmeticException("Denominator cannot be zero");
        }
        this.denominator = denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public static int gcd(int a, int b) {
        // The greatest common denominator of two numbers is the largest positive integer number that divides both the
        // numbers without leaving any remainder. For example, the greatest common divisor of 30 and 45 is 15.
        // https://stackoverflow.com/a/4009247
        if (b == 0)
            return Math.abs(a);
        return gcd(b,a % b);
    }

    public Fraction simplify() {
        // Write code to find the greatest common divisor of this Fraction object's numerator and denominator.
        int gcd = gcd(this.numerator, this.denominator);

        // Instantiate a new Fraction object called "simplified" where the numerator is the current numerator divided by
        // the greatest common divisor, and the denominator is the current denominator divided by the greatest common divisor.
        // For example, 75/45 is 5/3 (75 divided by 15 is 5, 45 divided by 15 is 3).
        Fraction simplified = new Fraction(this.numerator/gcd, this.denominator/gcd);
        // If the simplified fraction's numerator is greater than or equal to zero and the fraction's denominator
        // is less than zero, reverse their negativity
        //For example, 1/-2 would become -1/2
        if(simplified.numerator >= 0 && simplified.denominator <= 0 || simplified.numerator <= 0 && simplified.denominator <= 0) {
            simplified.numerator *= -1;
            simplified.denominator *= -1;
        }
        // Also, If the simplified fraction's numerator and denominator are both less than zero, remove their negativity.
        // For example, -1/-2 would become 1/2
        return simplified;
    }

    public String mixedNumber() {
        Fraction simplified = simplify();
        if(simplified.denominator == 1) {
            return simplified.numerator + "";
        } else if(Math.abs(simplified.numerator) > simplified.denominator) {
            int wholeNumber = Math.abs(simplified.numerator) / simplified.denominator;
            int remainder = Math.abs(simplified.numerator) % simplified.denominator;
            return simplified.numerator < 0 ? "-" : "" + wholeNumber + " " + remainder + "/" + simplified.denominator;
        } else if(simplified.numerator == 0) {
            return "0";
        } else {
            return simplified.toString();
        }
    }

    public String add(Fraction other) {
        Fraction result = new Fraction();
        result.setNumerator(this.numerator * other.denominator + this.denominator * other.numerator);
        result.setDenominator(this.denominator * other.denominator);
        return this.mixedNumber() + " + " + other.mixedNumber() + " = " + result.mixedNumber();
    }
}
