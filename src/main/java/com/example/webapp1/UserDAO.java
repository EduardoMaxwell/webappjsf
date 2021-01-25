package com.example.webapp1;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDAO {

    public void insert(User user) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public void updateOrInsert(User user) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            if (user.getId() != null) {
                manager.merge(user);
            } else {
                manager.persist(user);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public User findById(Integer id) {
        EntityManager manager = JPAUtil.getEntityManager();
        User user = null;
        try {
            manager.getTransaction().begin();
            user = manager.find(User.class, id);
            manager.getTransaction().commit();
            System.out.println(user.getId());
            System.out.println(user.getNome());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return user;
    }

    public void remove(User user) {
        EntityManager manager = JPAUtil.getEntityManager();
        System.out.println("ENTROU");
        try {
            manager.getTransaction().begin();
            User temp = manager.merge(user);
            manager.remove(temp);
            manager.getTransaction().commit();

        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public List<User> findAll() {
        EntityManager manager = JPAUtil.getEntityManager();

        return manager.createQuery("select u from User u").getResultList();
    }

}
