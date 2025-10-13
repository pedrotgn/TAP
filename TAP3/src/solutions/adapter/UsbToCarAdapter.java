package solutions.adapter;

//We choose an Object Adapter implementation because the Target isn't an Interface
public class UsbToCarAdapter extends CigaretteLighterReceptacle implements Usb {

	public int getPower(){
		return getEnergy();
	}

}
