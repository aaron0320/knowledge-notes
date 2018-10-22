import java.math.*;

class FibonacciClient {
	public static void main(String[] args) {
		System.out.println(fibonacci(8181));
	}
	
	public static BigInteger fibonacci(final int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n should be positive");
		} else if (n == 0) {
			return BigInteger.ZERO;
		} else if (n == 1) {
			return BigInteger.ONE;
		} else {
			// Recursively perform fibonacci n-1 times, e.g. f(2) perform 1 fibonacci
			return fibonacci(n - 1, BigInteger.ONE, BigInteger.ZERO);
		}
	}
	
	private static BigInteger fibonacci(final int n, final BigInteger fnMinusOne, 
		final BigInteger fnMinusTwo) {
			if (n == 0) {
				return fnMinusOne;
			}
				
			BigInteger fn = fnMinusOne.add(fnMinusTwo);
			return fibonacci(n - 1, fn, fnMinusOne);
	}
}
