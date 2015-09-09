package others;

import java.io.*;

public class Test2
{
	public static void main(String args[])
	{
		try{
			Person p = new Person("Pedro",24);

			FileOutputStream f = new FileOutputStream ("pedro.ser");
			ObjectOutputStream fos = new ObjectOutputStream (f);
			fos.writeObject(p);
			fos.close();


			ObjectInputStream fis = new ObjectInputStream (new FileInputStream ("pedro.ser"));
			Person w = (Person)fis.readObject();
			System.out.println(w.name+" "+w.age);

		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e2){
			e2.printStackTrace();
		}catch (ClassNotFoundException e3){
			e3.printStackTrace();
		}
	}
}