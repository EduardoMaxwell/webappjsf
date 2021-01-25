package com.example.webapp1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        dao.findAll();
    }
}
