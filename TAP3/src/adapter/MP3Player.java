package adapter;

//Client
public class MP3Player {
	private String brand;
	private int storageCapacity;
	private int batteryLevel = 0;
	private Usb batteryChargerInterface;
	
	public MP3Player(String brand, int storageCapacity, Usb batteryCharger) {
		this.brand = brand;
		this.storageCapacity = storageCapacity;
		this.batteryChargerInterface = batteryCharger;
	}
	
	public void charge(){
		System.out.println("--- Battery level before: "+batteryLevel+" ---");
		batteryLevel = batteryLevel + batteryChargerInterface.getPower();
		System.out.println("--- Battery level after: "+batteryLevel+" ---");
	}

	public String getBrand() {
		return brand;
	}

	public int getStorageCapacity() {
		return storageCapacity;
	}
	
	
}
