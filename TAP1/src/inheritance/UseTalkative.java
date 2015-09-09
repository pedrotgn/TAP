package inheritance;


public class UseTalkative {

	public static void main(String[] args) {
		Homer homer = new Homer();
		Bart bart = new Bart();
		
		Talkative springfield [] =new Talkative [2]; 
		springfield[0] = homer; 
		springfield[1] = bart; 
		
		for (Talkative h:springfield) 
				  System.out.println(h.talk());

	}

}
