package org.eug.todo.controller.impl;

import org.eug.todo.bean.User;
import org.eug.todo.controller.exception.ControllerException;
import org.eug.todo.controller.exception.handler.CustomExceptionHandler;
import org.eug.todo.controller.iface.UserController;
import org.eug.todo.service.exception.ServiceException;
import org.eug.todo.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

//@Validated
//@CustomExceptionHandler
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Override
    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUserLists() throws ControllerException {
        try {
            return userService.list();
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @Override
    @PostMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser(@Valid @RequestBody User user) throws ControllerException {
        try {
            return userService.saveUser(user);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
}