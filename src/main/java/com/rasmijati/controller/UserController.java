package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.repository.UserRepository;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
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
    }

    public void beforeCreate() {
        this.user = new User();
    }

    public void create() {
        try {
            userRepository.Create(this.user);
            this.users = userRepository.ShowAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User added successfully"));
            beforeCreate(); 
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to add user"));
        }
    }

    public void beforeEdit(User user) {
        this.user = userRepository.ShowById(user.getId());
    }

    public void edit() {
        try {
            userRepository.Edit(this.user);
            this.users = userRepository.ShowAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User updated successfully"));
            beforeEdit(user);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update user"));
        }
    }

    public void delete(User user) {
        try {
            userRepository.Delete(user);
            this.users = userRepository.ShowAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User deleted successfully"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to delete user"));
        }
    }
}
