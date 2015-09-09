package stacks;

public class UseStack {
	
	
	public static void main(String[] args) {
		
		Stack<Integer> pila;
		
		Integer lista[]= new Integer[5];
		pila = new ArrayStack<Integer>(lista);
		pila.push(3000);
		pila.push(7000);
		pila.push(9000);
		
		for (Integer i:pila)
			System.out.println(i);
		
	//	test(pila);
		
		pila = new VectorStack<Integer>(10);
		pila.push(3);
		pila.push(7);
		pila.push(9);
		
		
		for (Integer i:pila)
			System.out.println(i);
		
		test(pila);
		
		
		
	
	}
	
	public static void test(Stack<Integer> p){
		int i = 0;
		while (!p.full()) {
			p.push(10 * i);
			i++;
		}
		
		while (!p.empty()) {
			System.out.println(p.pop());
		}
	}
	
	public static <T> void test2(Stack<T> p){
		
		while (!p.empty()) {
			System.out.println(p.pop());
		}
	}
	
	
}
