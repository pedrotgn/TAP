package decorator;

//This class is abstract because we will never need an instance
public abstract class CarDecorator extends Car{

	private Car car;

	public CarDecorator(Car car) {
		super(car.getDescription(),car.getPrice());
		this.car = car;
	}
	
	public String getDescription() {
		return car.getDescription();
	}
	
	public float getPrice() {
		return car.getPrice();
	}
}
