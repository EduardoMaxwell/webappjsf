package com.example.webapp1.daointerfaces;

import java.io.Serializable;
import java.util.List;

public interface DAO<T> extends Serializable {
    public abstract T save(T entity);

    public abstract T update(T entity);

    public abstract List<T> listaAll(T entity);
}
