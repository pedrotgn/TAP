package decorator;

public class SpoilerDecorator extends CarDecorator{

	public SpoilerDecorator(Car car) {
		super(car);
	}
	
	public String getDescription() {
		return (super.getDescription()+" with a spoiler");
	}
	
	public float getPrice() {
		return (super.getPrice()+200);
	}

}
