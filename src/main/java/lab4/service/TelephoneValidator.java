package lab4.service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class TelephoneValidator implements ConstraintValidator<Telephone, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (s == null)
            return true;

        String telephonePattern = "^(?:\\+3)?8?(0\\d{9})$";
        boolean isValid = Pattern.compile(telephonePattern).matcher(s).matches();

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("must be in correct international format")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
