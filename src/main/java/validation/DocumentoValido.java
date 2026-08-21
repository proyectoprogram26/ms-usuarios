package validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DocumentoValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DocumentoValido {

    String message() default "El documento de identidad debe contener solo números";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
