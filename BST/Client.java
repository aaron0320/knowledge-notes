class Client {
	public static void main(String[] args) {
		BST<String, Integer> bst = new BST();
		bst.put("Aaron", 100);
		bst.put("Lmeon", 19);
		bst.put("Heyman", 50);
		
		System.out.println(bst.get("Heyman") + ",");
		System.out.println(bst.min());
		System.out.println(bst.max());
		System.out.println(bst.floor("Han"));
		System.out.println(bst.ceiling("Han"));
		System.out.println(bst.rank("Hl"));
		System.out.println(bst.size());
		System.out.println(bst.keys());
		
		bst.delete("Aa");
		System.out.println(bst.keys());
	}
	
	
}