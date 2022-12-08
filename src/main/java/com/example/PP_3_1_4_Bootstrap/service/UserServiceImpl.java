package com.example.PP_3_1_4_Bootstrap.service;

import com.example.PP_3_1_4_Bootstrap.DAO.UserDAO;
import com.example.PP_3_1_4_Bootstrap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;


    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;

    }


    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public List<User> getList() {
        return userDAO.getList();
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);

    }

    @Override
    @Transactional
    public void editUser(User user) {
        userDAO.editUser(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = (User)userDAO.getUser(email);
        user.getRoles().size();
        return user;
    }
    @Override
    @Transactional
    public User loadUserByUserEmail(String email)throws UsernameNotFoundException {
        User user = (User)userDAO.getUserEmail(email);
        user.getRoles().size();
        return user;
    }
}
