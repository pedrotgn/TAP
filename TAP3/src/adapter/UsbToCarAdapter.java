package adapter;

//We choose an Object Adapter implementation because the Target isn't an Interface
public class UsbToCarAdapter extends Usb{

	private CigaretteLighterReceptacle carInterface;

	public UsbToCarAdapter(CigaretteLighterReceptacle carInterface) {
		this.carInterface = carInterface;
	}
	
	public int getPower(){
		return carInterface.getEnergy();
	}

}
