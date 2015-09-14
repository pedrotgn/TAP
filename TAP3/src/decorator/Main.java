package decorator;

public class Main {

	public static void main(String[] args) {
		
		Car myCar = new Car("Chevrolet",10000);
		
		//Let's decorate
		myCar=new NitroDecorator(myCar);
		myCar=new SpoilerDecorator(myCar);
		
		System.out.println("Description: "+myCar.getDescription());
		System.out.println("Price: "+myCar.getPrice()+"�");
	}

}
