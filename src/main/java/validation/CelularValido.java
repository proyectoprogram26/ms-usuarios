package validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CelularValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CelularValido {

    String message() default "El celular debe tener máximo 13 caracteres y solo puede contener números y el símbolo +";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
