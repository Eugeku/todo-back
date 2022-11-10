package org.eug.todo.controller.impl;

import org.eug.todo.bean.Task;
import org.eug.todo.controller.exception.ControllerException;
import org.eug.todo.controller.iface.TaskController;
import org.eug.todo.exceptionhandler.CustomExceptionHandler;
import org.eug.todo.service.exception.ServiceException;
import org.eug.todo.service.iface.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@CustomExceptionHandler
@RestController
public class TaskControllerImpl implements TaskController {

    @Autowired
    private TaskService taskService;

    @Override
    @GetMapping(path = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getTaskLists() throws ControllerException {
        try {
            return taskService.list();
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping(path = "/tasks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Task> getTaskById(@PathVariable @Min(value = 0) Long id) throws ControllerException {
        try {
            return taskService.getTaskById(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @Override
    @PostMapping(path = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task saveTask(@Valid @RequestBody Task task) throws ControllerException {
        try {
            return taskService.saveTask(task);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
}