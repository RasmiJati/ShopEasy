/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless   //to resolve unsatisfied dependency (no bean matches the injection point )
public class UserRepository extends AbstractRepository<User> {

    @PersistenceContext(name = "ShopEasy")   // inject entity manager
    private EntityManager em;

    public UserRepository() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
