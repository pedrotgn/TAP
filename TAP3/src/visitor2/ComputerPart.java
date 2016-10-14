package visitor2;

/**
 * Created by milax on 14/10/16.
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
