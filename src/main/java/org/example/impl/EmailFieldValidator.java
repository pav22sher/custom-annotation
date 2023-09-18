package org.example.impl;

import org.example.annotation.Email;
import org.example.validation.BrokenField;
import org.example.validation.FieldValidator;
import org.example.validation.ValidationException;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class EmailFieldValidator implements FieldValidator {
    @Override
    public BrokenField validate(Object entity, Field field) {
        if (String.class.isAssignableFrom(field.getType())) {
            Email annotation = field.getAnnotation(Email.class);
            String regex = annotation.regex();
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            try {
                String fieldValue = (String) field.get(entity);
                if (fieldValue != null
                        && !fieldValue.isEmpty()
                        && !pattern.matcher(fieldValue).find()) {
                    return new BrokenField(field.getName(), fieldValue, "email");
                }
            } catch (IllegalAccessException e) {
                throw new ValidationException(e);
            }
        }
        return null;
    }
}
