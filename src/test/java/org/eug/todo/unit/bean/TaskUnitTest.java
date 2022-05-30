package org.eug.todo.unit.bean;

import org.eug.todo.bean.Task;
import org.eug.todo.unit.BaseUnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.eug.todo.core.data.Constant.NOT_EXPECTED_ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Task unit tests")
public class TaskUnitTest extends BaseUnitTest {

    @Autowired
    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
    }

    @Test
    @DisplayName("Getter and setters test")
    void gettersSettersTest() {
        Task expectedTask = new Task();
        expectedTask.setId(RANDOM.nextLong());
        expectedTask.setName("" + RANDOM.nextInt());
        expectedTask.setDescription("test");
        expectedTask.setPriority(12);
        expectedTask.setDate(new Date());
        task = expectedTask.clone();

        assertAll(
                () -> assertEquals(expectedTask.getId(), task.getId(), String.format(NOT_EXPECTED_ERROR_MESSAGE + "ID")),
                () -> assertEquals(expectedTask.getName(), task.getName(), String.format(NOT_EXPECTED_ERROR_MESSAGE + "name")),
                () -> assertEquals(expectedTask.getDescription(), task.getDescription(), String.format(NOT_EXPECTED_ERROR_MESSAGE + "description")),
                () -> assertEquals(expectedTask.getPriority(), task.getPriority(), String.format(NOT_EXPECTED_ERROR_MESSAGE + "priority")),
                () -> assertEquals(expectedTask.getDate(), task.getDate(), String.format(NOT_EXPECTED_ERROR_MESSAGE + "date"))
        );
    }


    @Test
    @DisplayName("Equals clone test")
    void equalsTest() {
        Task expectedTask = new Task();
        task = expectedTask.clone();

        assertEquals(expectedTask, task, String.format(NOT_EXPECTED_ERROR_MESSAGE + "object"));
    }

    @Test
    @DisplayName("Equals same test")
    void equalsSameTest() {
        Task expectedTask = task;

        assertEquals(expectedTask, task, String.format(NOT_EXPECTED_ERROR_MESSAGE + "object"));
    }

    @Test
    @DisplayName("Not equals different object test")
    void notEqualsObjectTest() {
        Object expectedTask = new Object();

        assertNotEquals(expectedTask, task, String.format(NOT_EXPECTED_ERROR_MESSAGE + "object"));
    }

    @Test
    @DisplayName("Not equals null test")
    void notEqualsNullTest() {
        assertNotEquals(task, null, String.format(NOT_EXPECTED_ERROR_MESSAGE + "object"));
    }

    @Test
    @DisplayName("Not equals test by ID")
    void notEqualsIDTest() {
        Task expectedTask = new Task();
        task = expectedTask.clone();
        task.setId(RANDOM.nextLong());
        task.setName("" + RANDOM.nextInt());
        task.setDescription("" + RANDOM.nextInt());
        task.setPriority(RANDOM.nextInt());
        task.setDate(new Date());

        assertNotEquals(expectedTask, task, String.format(NOT_EXPECTED_ERROR_MESSAGE + "object"));
    }
}