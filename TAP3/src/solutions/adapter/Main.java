package solutions.adapter;

public class Main {

	public static void main(String[] args) {
		MP3Player myPlayer = new MP3Player("SanDisk",4, new UsbToCarAdapter());
		myPlayer.charge();
	}

}
