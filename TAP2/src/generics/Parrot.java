package generics;

/**
 * @author Pedro Garcia
 *
 */
public class Parrot extends Animal {

	
	public Parrot(int patas, int ojos) {
		super(patas, ojos);
	}
	
	// Refinamiento
	
	public String talk()
	{
		return "Soy un Loro y "+ super.talk();
	}

}
