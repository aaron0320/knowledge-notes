import java.util.*;

class StdRandom {
	public static void shuffle(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int r = uniform(i + 1);
			exch(a, i, r);
		}
	}
	
	public static int uniform(int max) {
		// FIXME - Not uniformly random
		Random rand = new Random();
		return rand.nextInt(max);
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}