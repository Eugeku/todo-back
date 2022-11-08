package org.eug.todo.service.impl;

import org.eug.todo.bean.Task;
import org.eug.todo.dao.iface.TaskRepository;
import org.eug.todo.service.exception.ServiceException;
import org.eug.todo.service.iface.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> list() throws ServiceException {
        try {
            return taskRepository.findAll();
        } catch (Exception exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public Optional<Task> getTaskById(Long id) throws ServiceException {
        try {
            Assert.notNull(id, "Empty id exception");
            throw new IllegalArgumentException("Empty id exception");
//            return taskRepository.findById(id);
        } catch (Exception exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public Task saveTask(Task task) throws ServiceException {
        try {
            Assert.notNull(task, "Empty element exception");
            return taskRepository.save(task);
        } catch (Exception exception) {
            throw new ServiceException(exception);
        }
    }
}