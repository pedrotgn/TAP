package factory;

// Client
public class Main {
	public static void main(String[] args) {
		AbstractCarFactory factory = new SpanishCarFactory();

		// the client can work with the factory in a unique way, regardless of
		// its specific type. He also can create a car and use it without knowing
		// details of its creation and its specific type
		AbstractCar car = factory.createCar();
		System.out.println(car.getDriverSide());
	}
}
