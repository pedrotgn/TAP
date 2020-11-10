package visitor2;

/**
 * Created by milax on 14/10/16.
 */
public class Test {
    public static void main(String[] args) {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
