package org.eug.todo.validation.bean;

import org.eug.todo.bean.Task;
import org.eug.todo.bean.User;
import org.eug.todo.core.utils.ValidationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.eug.todo.core.data.Constant.NOT_EXPECTED_ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Task validation")
public class TaskValidationTest {

    @Autowired
    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setDate(new Date());
        task.setName("name");
        task.setPriority(0);
        task.setUser(new User());
    }

    @Test
    @DisplayName("Task name validation")
    void whenNameIsIncorrectValidationTest() {
        int expectedErrors = 1;
        task.setName("");

        assertEquals(expectedErrors, ValidationUtils.validate(task), NOT_EXPECTED_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Task date validation")
    void whenDateIsIncorrectValidationTest() {
        int expectedErrors = 1;
        task.setDate(null);

        assertEquals(expectedErrors, ValidationUtils.validate(task), NOT_EXPECTED_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Task priority validation")
    void whenPriorityIsIncorrectValidationTest() {
        int expectedErrors = 1;
        task.setPriority(-1);

        assertEquals(expectedErrors, ValidationUtils.validate(task), NOT_EXPECTED_ERROR_MESSAGE);
    }
}