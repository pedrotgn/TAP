package annotations;

import java.lang.annotation.Annotation;

/**
 * Created by pedro on 9/24/15.
 */
public class ReflectMain {

    public static void main(String args[]){
        Class<Person> obj = Person.class;

           if (obj.isAnnotationPresent(Copyright.class)) {

            Annotation annotation = obj.getAnnotation(Copyright.class);
            Copyright copy = (Copyright) annotation;


            System.out.printf("%nPriority :%s", copy.priority());
            System.out.printf("%nCreatedBy :%s", copy.createdBy());
            System.out.printf("%nTags :");

            int tagLength = copy.tags().length;
            for (String tag : copy.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%nLastModified :%s%n%n", copy.lastModified());

        }



    }
}
