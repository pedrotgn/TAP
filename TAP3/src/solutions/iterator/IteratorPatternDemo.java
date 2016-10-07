package solutions.iterator;

/**
 * http://www.tutorialspoint.com/design_pattern/iterator_pattern.htm
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for(String elem:namesRepository){

            System.out.println("Name : " + elem);
        }
    }
}
