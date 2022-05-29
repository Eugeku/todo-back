package org.eug.todo.dao.impl;

import org.eug.todo.bean.Task;
import org.eug.todo.dao.exception.DAOException;
import org.eug.todo.dao.iface.TaskRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TaskRepositoryImpl extends TaskRepository {

    /**
     * Non-CRUID operations to db with some specific logic.
     */
    @Override
    default List<Task> getAllTasks() throws DAOException {
        try {
            return new ArrayList<>();
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }
}