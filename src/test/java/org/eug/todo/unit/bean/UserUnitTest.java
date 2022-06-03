package org.eug.todo.unit.bean;

import org.eug.todo.bean.User;
import org.eug.todo.unit.BaseUnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.eug.todo.core.data.Constant.NOT_EXPECTED_ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("User unit tests")
public class UserUnitTest extends BaseUnitTest {

    @Autowired
    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    @DisplayName("Getter and setters test")
    void gettersSettersTest() {
        User expectedUser = new User();
        expectedUser.setId(RANDOM.nextLong());
        expectedUser.setName("" + RANDOM.nextInt());
        expectedUser.setDescription("" + RANDOM.nextInt());
        expectedUser.setSurname("" + RANDOM.nextInt());
        user = expectedUser.clone();

        assertAll(
                () -> assertEquals(expectedUser.getId(), user.getId(), String.format(NOT_EXPECTED_ERROR_MESSAGE + "ID")),
                () -> assertEquals(expectedUser.getName(), user.getName(), String.format(NOT_EXPECTED_ERROR_MESSAGE + "name")),
                () -> assertEquals(expectedUser.getDescription(), user.getDescription(), String.format(NOT_EXPECTED_ERROR_MESSAGE + "description")),
                () -> assertEquals(expectedUser.getSurname(), user.getSurname(), String.format(NOT_EXPECTED_ERROR_MESSAGE + "surname"))
        );
    }


    @Test
    @DisplayName("Equals clone test")
    void equalsTest() {
        User expectedUser = new User();
        user = expectedUser.clone();

        assertEquals(expectedUser, user, String.format(NOT_EXPECTED_ERROR_MESSAGE + "object"));
    }

    @Test
    @DisplayName("Equals same test")
    void equalsSameTest() {
        User expectedUser = user;

        assertEquals(expectedUser, user, String.format(NOT_EXPECTED_ERROR_MESSAGE + "object"));
    }

    @Test
    @DisplayName("Not equals different object test")
    void notEqualsObjectTest() {
        Object expectedUser = new Object();

        assertNotEquals(expectedUser, user, String.format(NOT_EXPECTED_ERROR_MESSAGE + "object"));
    }

    @Test
    @DisplayName("Not equals null test")
    void notEqualsNullTest() {
        assertNotEquals(user, null, String.format(NOT_EXPECTED_ERROR_MESSAGE + "object"));
    }

    @Test
    @DisplayName("Not equals test by fields")
    void notEqualsIDTest() {
        User expectedUser = new User();
        user = expectedUser.clone();
        user.setId(RANDOM.nextLong());
        user.setName("" + RANDOM.nextInt());
        user.setDescription("" + RANDOM.nextInt());
        user.setSurname("" + RANDOM.nextInt());

        assertNotEquals(expectedUser, user, String.format(NOT_EXPECTED_ERROR_MESSAGE + "object"));
    }
}