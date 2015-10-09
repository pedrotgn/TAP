package solutions.visitor;

import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Directory root = new Directory("root");
		Directory home = new Directory("home");
		Directory lp = new Directory("lp");
		File f1 = new File("f1",1234,"pedro");
		File f2 = new File("f2",3445,"pep");
		File f3 = new File("f3",6688,"pedro");
		File f4 = new File("lp",99999,"jordi");
		root.addChild(home);
		root.addChild(f1);
		home.addChild(lp);
		home.addChild(f2);
		lp.addChild(f3);
		root.addChild(f4);
		
		root.ls();
		System.out.println("-------------");
		
	
		System.out.println(f3);

		System.out.println("-------------");

		

		List<AComponent> result3 = root.toList();
		for (AComponent a:result3)
			System.out.println(a);
		
		System.out.println("Visitor code:-----size");
		SizeVisitor vs = new SizeVisitor();
		root.accept(vs);
		System.out.println("Size:"+ vs.getSize());
		
		System.out.println("Visitor code:-----search");
		SearchVisitor search = new SearchVisitor("f3");
		root.accept(search);
		List<File> results = search.getResults();
		for (File f:results)
			System.out.println(f);
	
		System.out.println("Visitor code:-----owner");
		OwnerVisitor owner = new OwnerVisitor("pedro");
		root.accept(owner);
		List<File> results2 = owner.getResults();
		for (File f:results2)
			System.out.println(f);
		
		
	}

}
