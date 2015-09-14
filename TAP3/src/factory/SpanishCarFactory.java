package factory;

class SpanishCarFactory implements AbstractCarFactory{
	
	public AbstractCar createCar(){
		return new SpanishCar();
	}
	
}

