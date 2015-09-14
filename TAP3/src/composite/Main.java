package composite;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Directory root = new Directory("root");
		Directory home = new Directory("home");
		Directory tap = new Directory("tap");
		File f1 = new File("f1",1234);
		File f2 = new File("f2",3445);
		File f3 = new File("f3",6688);
		File f4 = new File("lp",99999);
		root.addChild(home);
		root.addChild(f1);
		home.addChild(tap);
		home.addChild(f2);
		tap.addChild(f3);
		root.addChild(f4);

		
		System.out.println("-------------");
		
		System.out.println("Root SIZE:"+root.size());
		System.out.println("Home SIZE:"+home.size());
		System.out.println("TAP SIZE:"+tap.size());
		
		
	}

}
