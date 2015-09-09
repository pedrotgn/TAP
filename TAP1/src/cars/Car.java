package cars;
public class Car {
	private String brand;
	private int price;

	public Car(String brand, int price) {
		this.brand = brand;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String getBrand() {
		return brand;
	}

	// Method to determine if two cars are equals
	public boolean equals(Car car) {
		Car other = car;
		return (other.getPrice() == this.price)
				&& (other.getBrand().equals(this.brand));
	}

	// Method to create another car with the same characteristics
	public Car clone() {
		return new Car(brand, price);
	}

	public String toString() {
		return "(" + brand + "," + price + ")";
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
