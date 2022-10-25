package org.eug.todo.integration;

import org.eug.todo.bean.Task;
import org.eug.todo.bean.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public class IntegrationTaskControllerTest extends BaseIntegrationTest {

    @Test
    public void getTasksListTest() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/tasks", String.class);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void saveOneTaskTest() {
        Task task = new Task();
        task.setName("name");
        task.setDescription("description");
        task.setPriority(1);
        task.setDate(new Date());
        task.setUser(new User());
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:" + port + "/tasks", task, String.class);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
}