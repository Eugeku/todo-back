package org.eug.todo.dao.iface;

import org.eug.todo.bean.Task;
import org.eug.todo.dao.exception.DAOException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> getAllTasks() throws DAOException;
}