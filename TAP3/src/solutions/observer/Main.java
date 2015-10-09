package solutions.observer;




public class Main {


	public static void main(String[] args) {
		testStrings();
		testIntegers();
	}
	
	public static void testStrings() {

		ObserverListImpl<String> strings = new ObserverListImpl<String>();


		try {
			strings.register(new PrinterObserver<String>());
			strings.register(new BackupObserver<String>());

		} catch (RepeatedObserverException e) {
			System.out.println("Existent Observer Exception....");
			System.out.println("   '---> " + e.getMessage());
		}


		for (String s:new String[]{"hola", "adios", "hello", "goodbye"})
			strings.add(s);


		System.out.println("List content:");
		for (String s:strings)
			System.out.println(s);
		System.out.println();


		try {
			strings.register(new BackupObserver<String>());
		} catch (RepeatedObserverException e) {
			System.out.println("CExistent Observer...");
			System.out.println("   '---> " + e.getMessage());
		}
	}

	public static void testIntegers() {

		ObserverListImpl<Integer> integers = new ObserverListImpl<Integer>();


		try {
			integers.register(new PrinterObserver<Integer>());
			integers.register(new BackupObserver<Integer>());
		} catch (RepeatedObserverException e) {
			System.out.println("Existent Observer.");
			System.out.println("   '---> " + e.getMessage());
		}
		

		for (Integer s:new Integer[]{ 4, 6, 3, 5, 4 })
			integers.add(s);
		

		System.out.println("List content:");
		for (Integer s:integers)
			System.out.println(s);
		System.out.println();
		
	}

}
