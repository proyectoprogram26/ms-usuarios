package validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class MayorDeEdadValidator implements ConstraintValidator<MayorDeEdad, LocalDate> {

    private static final int EDAD_MINIMA = 18;

    @Override
    public boolean isValid(LocalDate fechaNacimiento, ConstraintValidatorContext context) {
        // dejamos que @NotNull se encargue de los nulos
        if (fechaNacimiento == null) {
            return true;
        }

        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= EDAD_MINIMA;
    }
}
