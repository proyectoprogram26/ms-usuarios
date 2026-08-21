package validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CelularValidator implements ConstraintValidator<CelularValido, String> {

    @Override
    public boolean isValid(String celular, ConstraintValidatorContext context) {

        if (celular == null || celular.isEmpty()) {
            return true;
        }

        if (celular.length() > 13) {
            return false;
        }

        int inicio = 0;

        if (celular.charAt(0) == '+') {
            inicio = 1;
        }

        for (int i = inicio; i < celular.length(); i++) {
            if (!Character.isDigit(celular.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
