package org.eug.todo.controller.iface;

import org.eug.todo.bean.User;

import java.util.List;

public interface UserController {

    List<User> getUserLists();

    User saveUser(User newUser);
}