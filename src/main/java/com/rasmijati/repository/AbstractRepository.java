/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.IEntity;
import com.rasmijati.model.IRepository;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author admin
 * @param <T>
 */
public abstract class AbstractRepository<T extends IEntity> implements IRepository<T> {

    protected abstract EntityManager getEntityManager();
    private Class<T> entityClass;

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void Create(T t) {
        getEntityManager().persist(t);
        getEntityManager().flush();
    }

    @Override
    public List<T> ShowAll() {
        return getEntityManager().createQuery("select t from " + entityClass.getName() + "t").getResultList();
    }

    @Override
    public T ShowById(Long id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public void Edit(T t) {
        getEntityManager().merge(t);
        getEntityManager().flush();
    }

    @Override
    public void Delete(T t) {
        getEntityManager().remove(t);
        getEntityManager().flush();
    }

}
