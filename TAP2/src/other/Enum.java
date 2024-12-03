package other;

public class Enum {

	enum Season { WINTER, SPRING, SUMMER, FALL }
	
	public static void main(String[] args) {
		
		
		Season temporada;
		
		temporada = Season.WINTER;
		
		switch (temporada){
			case SUMMER:  System.out.println("verano");
			case FALL: System.out.println("oto�o");
			case SPRING: System.out.println("primavera");
			case WINTER: System.out.println("invierno");
		}
		
		Season[] lista = Season.values();
		for (Season s:lista)
			System.out.println(s);
		
	}

}
