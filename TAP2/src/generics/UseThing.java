package generics;

import static java.lang.System.out;

class UseThing {
    public static void main(String args[]) {
        Thing<String> cosa = new Thing<String>("pedro");
        String name = cosa.getName();
        out.println(name);
        //  cosa.setName(new Integer(7));  //ILEGAL !!

    }


}
