package org.eug.todo.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eug.todo.validation.bean.TaskValidationTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.eug.todo.core.data.Constant.AMOUNT_OF_ERRORS_D;
import static org.eug.todo.core.data.Constant.ATTENTION_ERROR_PROPERTY_S_VALUE_S_MESSAGE_S;

public class ValidationUtils {
    private static final Logger LOGGER = LogManager.getLogger(TaskValidationTest.class);

    public static int validate(Object object) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);

        LOGGER.info(object);
        LOGGER.info(String.format(AMOUNT_OF_ERRORS_D, constraintViolations.size()));

        for (ConstraintViolation<Object> cv : constraintViolations) {
            LOGGER.info(String.format(ATTENTION_ERROR_PROPERTY_S_VALUE_S_MESSAGE_S,
                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
        }

        return constraintViolations.size();
    }
}