package main.java.cmp.softwareAG;


public class Fraction
{
private int numerator, denominator;  // stores the fraction data

public Fraction()
{
   numerator = denominator = 0;
}

public int getNumerator()
{
   return numerator;
}
public void setNumerator(int num)
{
   numerator=num;
}
public int getDenominator()
{
   return denominator;
}
public void setDenominator(int den)
{
   denominator=den;
}

public Fraction add(Fraction b)
{
   if ((denominator == 0) || (b.denominator == 0))
      throw new IllegalArgumentException("invalid denominator");
   int common = lcd(denominator, b.denominator);
   Fraction commonA = new Fraction();
   Fraction commonB = new Fraction();
   commonA = convert(common);
   commonB = b.convert(common);
   Fraction sum = new Fraction();
   sum.numerator = commonA.numerator + commonB.numerator;
   sum.denominator = common;
   sum = sum.reduce();
   return sum;
}

public void input()
{
   // prompt user to enter numerator
   System.out.print("Please enter an integer for numerator: ");
   // get user input
   numerator = 2;
   // prompt user to enter denominator in a loop to prevent
   // an invalid (zero) value for denominator
   do {
      System.out.print("Please enter a non-zero integer for denominator: ");
      denominator = 6;
      // make sure it is non-zero
      if (denominator == 0)
         System.out.println("Invalid value.  Please try again.");
   } while (denominator == 0);
}

public void output()
{
    System.out.print(this);
}
public String toString()
{
   String buffer = numerator + "/" + denominator;
   return buffer;
}

private int lcd(int denom1, int denom2)
{
   int factor = denom1;
   while ((denom1 % denom2) != 0)
      denom1 += factor;
   return denom1;
}

private int gcd(int denom1, int denom2)
{
   int factor = denom2;
   while (denom2 != 0) {
      factor = denom2;
      denom2 = denom1 % denom2;
      denom1 = factor;
   }
   return denom1;
}
private Fraction convert(int common)
{
   Fraction result = new Fraction();
   int factor = common / denominator;
   result.numerator = numerator * factor;
   result.denominator = common;
   return result;
}

private Fraction reduce()
{
   Fraction result = new Fraction();
   int common = 0;
   // get absolute values for numerator and denominator
   int num = Math.abs(numerator);
   int den = Math.abs(denominator);
   // figure out which is less, numerator or denominator
   if (num > den)
      common = gcd(num, den);
   else if (num < den)
      common = gcd(den, num);
   else  // if both are the same, don't need to call gcd
      common = num;

   // set result based on common factor derived from gcd
   result.numerator = numerator / common;
   result.denominator = denominator / common;
   return result;
}

public static void main(String args[])
{
   Fraction f1 = new Fraction();   // local fraction objects
   Fraction f2 = new Fraction();   // used to test methods

   // one way to set up fractions is simply to hard-code some values
   f1.setNumerator(722);
   f1.setDenominator(143);
   f2.setNumerator(360);
   f2.setDenominator(176);

   // try some arithmetic on these fractions
   Fraction result = new Fraction();
   // test addition
   result = f1.add(f2);
   // one way to output results, using toString method directly
   System.out.println(f1 + " + " + f2 + " = " + result);

   System.out.println();

}

}
