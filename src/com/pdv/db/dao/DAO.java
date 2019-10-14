
package com.pdv.db.dao;

import java.util.List;

public interface DAO<T>{
    
    /*public abstract void insert(T obj) throws Throwable;

    public abstract void update(T obj) throws Throwable;

    public abstract void delete(T obj) throws Throwable;*/

    public abstract T getById(Integer id) throws Throwable;

    public abstract List<T> getAll() throws Throwable;
    
    
}
