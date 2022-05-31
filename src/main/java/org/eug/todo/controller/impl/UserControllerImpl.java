package org.eug.todo.controller.impl;

import org.eug.todo.bean.User;
import org.eug.todo.controller.iface.UserController;
import org.eug.todo.service.exception.ServiceException;
import org.eug.todo.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Override
    @GetMapping(path = "/users", produces = "application/json")
    public List<User> getUserLists() {
        try {
            return userService.list();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @PostMapping(path = "/users", produces = "application/json")
    public User saveUser(@RequestBody User user) {
        try {
            return userService.saveUser(user);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}