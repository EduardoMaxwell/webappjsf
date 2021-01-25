package com.example.webapp1;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class UserBean implements Serializable {
    private static final long serialVersionUID = 592987995612761126L;

    @Inject
    private User user;

    private List<User> users;

    public void salva() {
        UserDAO dao = new UserDAO();
        dao.insert(user);
        user = new User();
    }

    public void insereOuAtualiza() {
        UserDAO dao = new UserDAO();
        dao.updateOrInsert(user);
        user = new User();
    }

    public List<User> userList() {
        UserDAO dao = new UserDAO();
        users = dao.findAll();
        for (User user : users) {
            System.out.println(user.getId() + " | " + user.getNome());
        }
        return users;
    }

    public void remove(User user) {
        System.out.println("ENTROU");
        UserDAO dao = new UserDAO();
        users.remove(user);
        dao.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
