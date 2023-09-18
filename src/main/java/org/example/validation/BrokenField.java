package org.example.validation;

import java.util.Arrays;

public record BrokenField(String fieldName, Object fieldValue, String violatedRule, Object... args) {
    @Override
    public String toString() {
        return "BrokenField{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldValue=" + fieldValue +
                ", violatedRule='" + violatedRule + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
