class Client {
	public static void main(String[] args) {
		SeparateChaining<String, Integer> sc = new SeparateChaining();
		sc.put("Aaron", 1);
		sc.put("Harem", 2);
		sc.put("Mason", 5);
		sc.put("Mason", 3);
		
		System.out.println(sc.get("Mason"));
		
		LinearProbing<String, Integer> lp = new LinearProbing();
		lp.put("Aaron", 1);
		lp.put("Harem", 2);
		sc.put("Mason", 5);
		lp.put("Mason", 3);
		
		System.out.println(lp.get("Mason"));
	}
}