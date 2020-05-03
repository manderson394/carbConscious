package com.mattanderson.carbConscious.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Validates objects of the specified type at the time of instantiation of the <code>GenericValidator</code>.
 * @author Matt Anderson
 * @version 11
 *
 * @param <T> the type parameter
 */
public class GenericValidator<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());
    private ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private static Validator validator;
    private Map<String, String> errorMap;

    /**
     * Instantiates a new Generic validator.
     *
     * @param type the type
     */
    public GenericValidator(Class<T> type) {
        this.type = type;
        validator = validatorFactory.getValidator();
        errorMap = new HashMap<>();
    }

    /**
     * Validates a give object of the specified type, T.
     *
     * @param objectToValidate the object to validate
     * @return the map
     */
    public Map<String, String> validate(T objectToValidate) {

        Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);

        if (!violations.isEmpty()) {
            logger.info("Found validation errors for the object of type {}: {}", objectToValidate.getClass(),
                    objectToValidate);

            for (ConstraintViolation violation : violations) {
                String property = violation.getPropertyPath().toString();
                String message = violation.getMessage();

                errorMap.put(property, message);
            }
        } else {
            logger.info("No validation errors for the object of type {}: {}", objectToValidate.getClass(),
                    objectToValidate);
        }

        return errorMap;
    }
}
