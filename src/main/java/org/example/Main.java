package org.example;

import org.example.annotation.Email;
import org.example.annotation.MaxLength;
import org.example.annotation.MinLength;
import org.example.annotation.NotEmpty;
import org.example.dto.Address;
import org.example.dto.Person;
import org.example.impl.*;
import org.example.validation.BeanValidator;
import org.example.validation.FieldValidator;
import org.example.validation.ValidationResult;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static BeanValidator beanValidator;

    public static void main(String[] args) {
        init();
        shouldFailValidationOnEmailField();
        shouldFailValidationOnLoginField();
        shouldFailOnEmptyZipCodeField();
        shouldFailOnLongZipCodeField();
    }

    public static void init() {
        Map<Class<? extends Annotation>, FieldValidator> validatorMap = new HashMap<>();
        validatorMap.put(MaxLength.class, new MaxLengthFieldValidator());
        validatorMap.put(MinLength.class, new MinLengthFieldValidator());
        validatorMap.put(NotEmpty.class, new NotEmptyFieldValidator());
        validatorMap.put(Email.class, new EmailFieldValidator());
        beanValidator = new AnnotationBasedBeanValidator(validatorMap);
    }

    public static void shouldFailValidationOnEmailField() {
        Person person = new Person();
        person.setFirstName("Beverlee");
        person.setLastName("Skahill");
        person.setLogin("secret_login");
        person.setPassword("secret_password");
        person.setEmail("Beverlee@.com");
        ValidationResult result = beanValidator.validate(person);
        System.out.println(result);
    }

    public static void shouldFailValidationOnLoginField() {
        Person person = new Person();
        person.setFirstName("Beverlee");
        person.setLastName("Skahill");
        person.setLogin("123");
        person.setPassword("secretsecret");
        ValidationResult result = beanValidator.validate(person);
        System.out.println(result);
    }

    public static void shouldFailOnEmptyZipCodeField() {
        Address address = new Address();
        address.setAddressLine("672 Bayside Street");
        address.setZip(null);
        address.setCountry("US");
        ValidationResult result = beanValidator.validate(address);
        System.out.println(result);
    }

    public static void shouldFailOnLongZipCodeField() {
        Address address = new Address();
        address.setAddressLine("672 Bayside Street");
        address.setZip("952-1203 594");
        address.setCountry("US");
        ValidationResult result = beanValidator.validate(address);
        System.out.println(result);
    }
}