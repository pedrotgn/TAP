package decorator;

public class NitroDecorator extends CarDecorator{

	public NitroDecorator(Car car) {
		super(car);
	}
	
	public String getDescription() {
		return (super.getDescription()+" with nitrous oxide system");
	}
	
	public float getPrice() {
		return (super.getPrice()+7000);
	}

}
