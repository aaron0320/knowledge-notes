import java.math.*;

class RollDiceClient {
	public static void main(String[] args) {
		System.out.println(getPossibleWays(610));
	}
	
	public static BigInteger getPossibleWays(int targetN) {
		if (targetN < 1) {
			throw new IllegalArgumentException("n must be greater than 0");
		}
		return getPossibleWays(targetN, 1, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO);
	}
	
	private static BigInteger getPossibleWays(int targetN, int currentN, BigInteger fnMinusSix, BigInteger fnMinusFive, BigInteger fnMinusFour, BigInteger fnMinusThree, BigInteger fnMinusTwo, BigInteger fnMinusOne) {
		// no. of possible ways to n = Sum of no. of possible ways to reach fn-1 to fn-6
		BigInteger fn = fnMinusSix.add(fnMinusFive).add(fnMinusFour).add(fnMinusThree).add(fnMinusTwo).add(fnMinusOne);
		// If n is from 1 to 6, one extra way to reach n by directly rolling a dice
		if (currentN == 1 || currentN == 2 || currentN == 3 || 
			currentN == 4 || currentN == 5 || currentN == 6) {
			fn = fn.add(BigInteger.ONE);
		}
		
		if (targetN == currentN)
			return fn;
		else
			return getPossibleWays(targetN, currentN + 1, fnMinusFive, fnMinusFour, fnMinusThree, fnMinusTwo, fnMinusOne, fn);
	}
}

