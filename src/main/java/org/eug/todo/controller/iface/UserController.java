package org.eug.todo.controller.iface;

import org.eug.todo.bean.User;
import org.eug.todo.controller.exception.ControllerException;

import java.util.List;

public interface UserController {

    List<User> getUserLists() throws ControllerException;

    User saveUser(User newUser) throws ControllerException;
}