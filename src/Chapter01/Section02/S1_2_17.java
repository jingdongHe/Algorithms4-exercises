package Chapter01.Section02;

class Rational {
	public int numerator, denominator;

	public Rational(long numerator, long denominator) {
		
		long gcd = gcd(numerator, denominator);

		numerator /= gcd;
		denominator /= gcd;
		
		assert numerator<=Integer.MAX_VALUE && numerator>=Integer.MIN_VALUE:"over flow"; 
		assert denominator<=Integer.MAX_VALUE && denominator>=Integer.MIN_VALUE:"over flow"; 
		
		this.numerator = (int) numerator;
		this.denominator = (int) denominator;
	}

	private static long gcd(long a, long b) {
		return a == 0 ? b : gcd(b % a, a);
	}

	public Rational plus(Rational b) {
		return new Rational(numerator * b.denominator + b.numerator * denominator, denominator * b.denominator);
	}

	public Rational minus(Rational b) {
		return new Rational(numerator * b.denominator - b.numerator * denominator, denominator * b.denominator);
	}

	public Rational times(Rational b) {
		return new Rational(numerator * b.numerator, denominator * b.denominator);
	}

	public Rational divides(Rational b) {
		return new Rational(numerator * b.denominator, denominator * b.numerator);
	}

	public boolean equals(Rational that) {
		return numerator == that.numerator && denominator == that.denominator;
	}

	@Override
	public String toString() {
		return "Rational [" + numerator + "/" + denominator + "]";
	}

}

public class S1_2_17 {

	public static void main(String[] args) {
		System.out.println(new Rational(1, 2).plus(new Rational(1, 3)));
		System.out.println(new Rational(1, 2).minus(new Rational(1, 3)));
		System.out.println(new Rational(1, 2).times(new Rational(1, 3)));
		System.out.println(new Rational(1, 2).divides(new Rational(1, 3)));
		System.out.println(new Rational(1, 2).equals(new Rational(1, 2)));
	}

}
