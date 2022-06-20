package com.example.firstdemo.validatior;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdConstraint implements ConstraintValidator<IdValidate, Long> {
    @Override
    public void initialize(IdValidate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(s);
        return s != null;
    }
}
