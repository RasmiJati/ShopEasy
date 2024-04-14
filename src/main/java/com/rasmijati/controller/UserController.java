/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.repository.UserRepository;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author admin
 */

@Named
@ViewScoped     //Added @Named and @ViewScoped to the UserController class to register it in the Faces context.
public class UserController implements Serializable {

    private User user;
    private List<User> users;

    @Inject
    private UserRepository userRepository;  

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @PostConstruct
    public void init() {
        this.user = new User();
        this.users = userRepository.ShowAll();
        System.out.println(users.size());
    }

    public void beforeCreate() {
        this.user = new User();
    }

    public void create() {
        this.users = userRepository.ShowAll();
    }

    public void Show() {
        userRepository.ShowAll();
    }

    public void ShowById(Long id) {
        userRepository.ShowById(id);
    }

    public void beforeEdit(User user) {
        this.user = userRepository.ShowById(user.getId());
    }

    public void edit() {
        userRepository.Edit(this.user);
        this.users = userRepository.ShowAll();
    }

    public void delete(User user) {
        userRepository.Delete(user);
        users = userRepository.ShowAll();
    }
}
