package com.jaz2.figurines.Dictionary;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = DictionaryValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Dictionary {
    String value();

    String message() default "Invalid value for dictionary {value}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}