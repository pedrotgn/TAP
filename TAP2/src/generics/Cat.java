package generics;

/**
 * @author Pedro Garc�a 
 *
 */
public class Cat extends Animal {

	/**
	 * @param patas
	 * @param ojos
	 */
	public Cat(int patas, int ojos) {
		super(patas, ojos);
	}
	
	// Herencia con reemplazo de m�todo
	
	public String talk()
	{
		return "Soy un Gato";
	}

}
