package org.eug.todo.service.iface;

import org.eug.todo.bean.User;
import org.eug.todo.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    List<User> list() throws ServiceException;

    User saveUser(User task) throws ServiceException;
}
