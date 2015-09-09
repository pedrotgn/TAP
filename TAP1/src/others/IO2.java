package others;

import java.io.*;

public class IO2 {

	public static void main(String[] args) throws IOException {
		FileWriter fos = new FileWriter("pedro.txt");
		PrintWriter pos = new PrintWriter(fos);
		pos.println("Hello");
		pos.println("Bye");
		pos.close();

		FileReader fis = new FileReader("pedro.txt");
		BufferedReader dis = new BufferedReader(fis);
		System.out.println(dis.readLine());
		System.out.println(dis.readLine());
		dis.close();
	}

}
