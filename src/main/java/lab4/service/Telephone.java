package lab4.service;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelephoneValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Telephone {
    String message() default "{message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}