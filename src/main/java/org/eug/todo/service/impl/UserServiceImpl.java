package org.eug.todo.service.impl;

import org.eug.todo.bean.User;
import org.eug.todo.dao.iface.UserRepository;
import org.eug.todo.service.exception.ServiceException;
import org.eug.todo.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> list() throws ServiceException {
        try {
            return userRepository.findAll();
        } catch (Exception exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public User saveUser(User user) throws ServiceException {
        try {
            Assert.notNull(user, "Empty element exception");
            return userRepository.save(user);
        } catch (Exception exception) {
            throw new ServiceException(exception);
        }
    }
}