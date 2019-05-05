package com.example.mybatisdemo1.mapper;

import com.example.mybatisdemo1.dao.UserDao;
import com.example.mybatisdemo1.domin.User;
import com.example.mybatisdemo1.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:30
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void updatebyid(String id) {
        userDao.updatebyid(id);
    }

}