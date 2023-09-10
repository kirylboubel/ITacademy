package by.itacademy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Parametr {
//    String name () default "";

    String name();
//    String message() default "";
//    boolean isPattern() default  false;
}
