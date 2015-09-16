package solutions.bstree2;

public class Main {

	public static void main(String[] args) {
		BSTree<Integer> arbol = new BSTree<Integer>();
		arbol.insert(5);
		arbol.insert(3);
		arbol.insert(6);
		arbol.insert(1);
		arbol.insert(4);
		System.out.println(arbol.contains(4));
		System.out.println(arbol.contains(8));

		for (Integer elem:arbol)
			System.out.println(elem);
		
	}

}
