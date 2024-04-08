/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.model;

import java.util.List;

/**
 *
 * @author admin
 * @param <T>
 */
public interface IRepository<T> {

    public void Create(T t);

    public List<T> ShowAll();

    public T ShowById(Long id);

    public void Edit(T t);

    public void Delete(T t);
}
