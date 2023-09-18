package org.example.validation;

import java.lang.reflect.Field;

public interface FieldValidator {
    BrokenField validate(Object entity, Field field);
}
