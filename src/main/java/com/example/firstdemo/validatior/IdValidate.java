package com.example.firstdemo.validatior;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdConstraint.class)
public @interface IdValidate {

    String message() default "must be a whole number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
