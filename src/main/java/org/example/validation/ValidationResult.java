package org.example.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    private final List<BrokenField> brokenFields = new ArrayList<>();

    public void addBrokenFields(List<BrokenField> brokenFields) {
        this.brokenFields.addAll(brokenFields);
    }

    public List<BrokenField> getBrokenFields() {
        return new ArrayList<>(brokenFields);
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "brokenFields=" + brokenFields +
                '}';
    }
}
