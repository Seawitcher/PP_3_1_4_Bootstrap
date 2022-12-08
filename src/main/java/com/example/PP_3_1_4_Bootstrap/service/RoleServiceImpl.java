package com.example.PP_3_1_4_Bootstrap.service;

import com.example.PP_3_1_4_Bootstrap.DAO.RoleDAO;
import com.example.PP_3_1_4_Bootstrap.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }





    @Override
    @Transactional
    public boolean add(Role role) {
        roleDAO.add(role);
        return true;
    }

    @Override
    @Transactional
    public List<Role> getList() {
        return roleDAO.getList();
    }

    @Override
    @Transactional
    public Role getRole(Long id) {
        return roleDAO.getRole(id);
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        roleDAO.deleteRole(id);

    }

    @Override
    @Transactional
    public void editRole(Role role) {
        roleDAO.editRole (role);
    }
    @Override
    @Transactional
    public List<Role> listByRole(List<String> name) {
        return roleDAO.listByName(name);
    }
}
