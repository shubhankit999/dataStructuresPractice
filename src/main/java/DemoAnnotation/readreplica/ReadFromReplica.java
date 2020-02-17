package DemoAnnotation.readreplica;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Use @ReadFromReplica to use replica database
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ReadFromReplica {
    /**
     * enable flag can be true or false
     * @return
     */

    boolean enable() default true;
}
