package other;

public class Enum {

	enum Season { WINTER, SPRING, SUMMER, FALL } ;
	
	public static void main(String[] args) {
		
		
		Season temporada;
		
		temporada = Season.SUMMER;
		
		switch (temporada){
			case SUMMER:  System.out.println("verano");break;
			case FALL: System.out.println("oto�o");break;
			case SPRING: System.out.println("primavera");break;
			case WINTER: System.out.println("invierno");
		}
		
		Season lista []= Season.values();
		for (Season s:lista)
			System.out.println(s);
		
	}

}
