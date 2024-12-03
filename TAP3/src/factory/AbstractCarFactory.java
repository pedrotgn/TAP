package factory;

//An interface is chosen instead an abstract class
//because in this example aren't needed attributes and methods already implemented
 interface AbstractCarFactory{
	
	  AbstractCar createCar();
	
}

