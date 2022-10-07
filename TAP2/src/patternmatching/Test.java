package patternmatching;

public class Test {
    public static void main(String[] args) {

        InsultMessage m1 = new InsultMessage("me","Stupid");
        InsultMessage m2 = new InsultMessage("me","Stupid");
        QuitMessage m3 = new QuitMessage("me","BYE");

        processMessage(m1);
        processMessage(m2);
        processMessage(m3);





    }

    public static void processMessage(Message m){

        // UNCOMMENT WHEN ACTIVATED THE EXPERIMENTAL FEATURES
        // https://foojay.io/today/how-to-run-project-loom-from-intellij-idea/
      /*  switch (m){
            case InsultMessage m1 -> System.out.println(m1.getBody());
            case QuitMessage m1 -> System.out.println("BWYE BYE ");
            default -> System.out.println("ERROR");
        }*/

    }

}
