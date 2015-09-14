package adapter;

public class Main {

	public static void main(String[] args) {
		CigaretteLighterReceptacle carLighter = new CigaretteLighterReceptacle();
		MP3Player myPlayer = new MP3Player("SanDisk",4,new UsbToCarAdapter(carLighter));
		myPlayer.charge();
	}

}
