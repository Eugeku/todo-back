package org.eug.todo.integration;

import org.eug.todo.bean.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public class IntegrationTaskControllerTest extends BaseIntegrationTest {

    @Test
    public void testHello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/tasks", String.class);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testSaveUser() {
        Task task = new Task();
        task.setName("name");
        task.setDescription("description");
        task.setDate(new Date());
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:" + port + "/tasks", task, String.class);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
}