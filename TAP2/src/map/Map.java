package map;

public class Map {
	public static int[] map(int[] lista, IMap function){
		int[] result = new int[lista.length];
		for (int i = 0;i< lista.length; i++)
			result[i] = function.apply(lista[i]);
		return result;
		
	}

}
