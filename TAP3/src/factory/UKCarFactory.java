package factory;

class UKCarFactory implements AbstractCarFactory{
	
	public AbstractCar createCar(){
		return new UKCar();
	}
	
}

