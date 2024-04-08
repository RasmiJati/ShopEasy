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
import javax.inject.Inject;

/**
 *
 * @author admin
 */
public class UserController implements Serializable {

    private User user;
    private List<User> userList;

    @Inject
    private UserRepository userRepository;  

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @PostConstruct
    public void init() {
        this.user = new User();
        this.userList = userRepository.ShowAll();
        System.out.println(userList.size());
    }

    public void beforeCreate() {
        this.user = new User();
    }

    public void create() {
        this.userList = userRepository.ShowAll();
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
        this.userList = userRepository.ShowAll();
    }

    public void delete(User user) {
        userRepository.Delete(user);
        userList = userRepository.ShowAll();
    }
}
