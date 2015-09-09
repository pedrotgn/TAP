package map;

public class MapSample {

	public static void main(String[] args) {
		int list[] = {1,2,3,4,5};
		
		int result[] = Map.map(list,new Increment());

		for (int i : result)
			System.out.println(i);
		

		int result2[] = Map.map(list,new Square());
		for (int i : result2)
			System.out.println(i);

	}

}
