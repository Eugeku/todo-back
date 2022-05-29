package org.eug.todo.controller.iface;

import org.eug.todo.bean.Task;

import java.util.List;

public interface TaskController {

    List<Task> getTaskLists();

    Task saveTask(Task newEmployee);
}