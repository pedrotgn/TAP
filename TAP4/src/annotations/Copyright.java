package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created by pedro on 9/24/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //on class level
public @interface Copyright {

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    Priority priority() default Priority.MEDIUM;

    String[] tags() default "";

    String createdBy() default "pedro";

    String lastModified() default "today";

}