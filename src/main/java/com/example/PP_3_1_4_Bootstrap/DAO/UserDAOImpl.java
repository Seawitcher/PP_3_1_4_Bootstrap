package com.example.PP_3_1_4_Bootstrap.DAO;


import com.example.PP_3_1_4_Bootstrap.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getList() {
        return entityManager.createQuery("select distinct u from User u left join fetch u.roles ", User.class)
                .getResultList();
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }



    @Override
    public void deleteUser(Long id) {


        entityManager.createQuery(
                "DELETE User WHERE id = :id").setParameter("id", id).executeUpdate();


    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public UserDetails getUser(String email) {


        return entityManager.createQuery(
                        "SELECT u FROM User u WHERE u.email = :email", User.class).setParameter("email", email)
                .getSingleResult();
    }
    @Override
    public User getUserEmail(String email) {


        return entityManager.createQuery(
                        "SELECT u FROM User u WHERE u.email = :email", User.class).getSingleResult();
//        return entityManager.find(User.class, email);
    }
}
