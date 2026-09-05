package com.proyectointegrador.msusuarios.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DocumentoValidator implements ConstraintValidator<DocumentoValido, String> {

    @Override
    public boolean isValid(String documento, ConstraintValidatorContext context) {

        if (documento == null || documento.isEmpty()) {
            return true;
        }

        for (int i = 0; i < documento.length(); i++) {
            if (!Character.isDigit(documento.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
