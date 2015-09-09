package cars;
public class UseCar {
	public static void main(String[] args) {

		// Create cars
		Car myCar = new Car("bmw", 100);
		Car otherCar = new Car("seat", 10);
		Car copy = new Car("seat", 10);

		// Compare memory addresses
		if (otherCar == copy)
			System.out.println("equals  == otherCar and copy");

		// Use method equals in Car class
		if (otherCar.equals(copy))
			System.out.println("equals otherCar and copy");

		if (myCar.equals(otherCar))
			System.out.println("equals myCar and otherCar");
		System.out.println("My car: " + myCar);

		Car peugeot = new Car("peugeot", 900);
		Car renault;

		renault = peugeot;

		peugeot.setBrand("mercedes");
		System.out.println("Renault " + renault);
		System.out.println("Peugeot " + peugeot);

		Car audi = new Car("audi", 900);
		renault = audi.clone();
		renault.setBrand("ferrari");
		System.out.println("Renault " + renault);
		System.out.println("Audi: " + audi);

	}

}
