package solutions.iterator;


import java.util.*;

public class NameRepository implements Iterable<String> {
    public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

    @Override
    public java.util.Iterator<String> iterator() {
        return new NameIterator();
    }


    private class NameIterator implements Iterator<String> {

        int index;

        @Override
        public boolean hasNext() {

            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public String next() {

            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}