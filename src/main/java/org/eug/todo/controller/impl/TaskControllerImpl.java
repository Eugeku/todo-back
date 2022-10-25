package org.eug.todo.controller.impl;

import org.eug.todo.bean.Task;
import org.eug.todo.controller.iface.TaskController;
import org.eug.todo.service.exception.ServiceException;
import org.eug.todo.service.iface.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskControllerImpl implements TaskController {

    @Autowired
    TaskService taskService;

    @Override
    @GetMapping(path = "/tasks", produces = "application/json")
    public List<Task> getTaskLists() {
        try {
            return taskService.list();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @PostMapping(path = "/tasks", produces = "application/json")
    public Task saveTask(@Valid @RequestBody Task task) {
        try {
            return taskService.saveTask(task);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}