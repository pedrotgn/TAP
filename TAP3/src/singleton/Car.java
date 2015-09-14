package singleton;

public class Car {

	//The single instance
	private static Car car = new Car();
	
	private int fuelLevel=0;
	
	//Private constructor makes impossible to create foreign instances
	private Car() {}
	
	//The only way to get the instance
	public static Car getInstance(){
		return car;
	}
	
	public void fillUp(){
		fuelLevel=4;
	}
	
	public void run(){
		if (fuelLevel==0){
			System.out.println("Fill up please");
		}else{
			fuelLevel--;
			System.out.println("Ruuuuuun!!");
		}
	}
		
}