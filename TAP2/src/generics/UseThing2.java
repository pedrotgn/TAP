package generics;

/**
 * @author Pedro Garcia
 *
 */
public class UseThing2 {

	public static void main(String[] args) 
	{	
	
		Cat g = new Cat(1,2);
		Thing2<Cat> c = new Thing2<Cat>(g);
		c.setName(g);
		Cat g2 = c.getName();
		Animal a = c.getName();
		System.out.println(g2.talk());
		System.out.println(a.talk());
		
		
	//	Cosa2<String> c = new Cosa2<String>("www");  //ILEGAL !! 
		
			
	}
}
