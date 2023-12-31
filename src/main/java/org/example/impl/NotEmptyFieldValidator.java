package org.example.impl;

import org.example.validation.BrokenField;
import org.example.validation.FieldValidator;
import org.example.validation.ValidationException;

import java.lang.reflect.Field;
import java.util.Collection;

public class NotEmptyFieldValidator implements FieldValidator {
    @Override
    public BrokenField validate(Object entity, Field field) {
        if (Collection.class.isAssignableFrom(field.getType())) {
            try {
                Collection<?> fieldValue = (Collection<?>) field.get(entity);
                if (fieldValue == null || fieldValue.isEmpty()) {
                    return new BrokenField(field.getName(), fieldValue, "notEmpty");
                }
            } catch (IllegalAccessException e) {
                throw new ValidationException(e);
            }
        } else if (String.class.isAssignableFrom(field.getType())) {
            try {
                String fieldValue = (String) field.get(entity);
                if (fieldValue == null || fieldValue.isEmpty()) {
                    return new BrokenField(field.getName(), fieldValue, "notEmpty");
                }
            } catch (IllegalAccessException e) {
                throw new ValidationException(e);
            }
        }
        return null;
    }
}
