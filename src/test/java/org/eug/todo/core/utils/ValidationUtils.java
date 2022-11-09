package org.eug.todo.core.utils;

import lombok.extern.log4j.Log4j2;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.eug.todo.core.data.Constant.AMOUNT_OF_ERRORS_D;
import static org.eug.todo.core.data.Constant.ATTENTION_ERROR_PROPERTY_S_VALUE_S_MESSAGE_S;

@Log4j2
public class ValidationUtils {

    public static int validate(Object object) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);

        log.info(object);
        log.info(String.format(AMOUNT_OF_ERRORS_D, constraintViolations.size()));

        for (ConstraintViolation<Object> cv : constraintViolations) {
            log.info(String.format(ATTENTION_ERROR_PROPERTY_S_VALUE_S_MESSAGE_S,
                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
        }

        return constraintViolations.size();
    }
}