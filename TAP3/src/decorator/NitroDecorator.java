package decorator;

public class NitroDecorator extends Car{

	private Car client;

	public NitroDecorator(Car car) {
		super("",0);
		client = car;
	}
	
	public String getDescription() {
		return (client.getDescription()+" with nitrous oxide system");
	}
	
	public float getPrice() {
		return (client.getPrice()+7000);
	}

}
