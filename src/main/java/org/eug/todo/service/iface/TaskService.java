package org.eug.todo.service.iface;

import org.eug.todo.bean.Task;
import org.eug.todo.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> list() throws ServiceException;

    Optional<Task> getTaskById(Long id) throws ServiceException;

    Task saveTask(Task task) throws ServiceException;
}
