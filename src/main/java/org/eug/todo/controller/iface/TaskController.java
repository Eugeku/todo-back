package org.eug.todo.controller.iface;

import org.eug.todo.bean.Task;
import org.eug.todo.controller.exception.ControllerException;

import java.util.List;
import java.util.Optional;

public interface TaskController {

    List<Task> getTaskLists() throws ControllerException;

    Optional<Task> getTaskById(Long id) throws ControllerException;

    Task saveTask(Task newEmployee) throws ControllerException;
}