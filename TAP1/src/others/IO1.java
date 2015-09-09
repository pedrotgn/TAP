package others;

import java.io.*;


public class IO1 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("pedro.txt");
		PrintStream pos = new PrintStream(fos);
		pos.println("Hello");
		pos.println("Bye");
		pos.close();
		
		FileInputStream fis = new FileInputStream("pedro.txt");
		DataInputStream dis = new DataInputStream(fis);
		System.out.println(dis.readLine());
		System.out.println(dis.readLine());
		dis.close();
		

	}

}
