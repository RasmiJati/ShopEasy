/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.controller;

import com.rasmijati.model.Product;
import com.rasmijati.repository.ProductRepository;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author admin
 */
@Named
@ViewScoped
public class ProductController implements Serializable {

    private Product product;
    private List<Product> list;

    private ProductRepository productRepository;

    public Product getProduct() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        this.product = new Product();
        this.list = productRepository.ShowAll();
    }

    public void beforeCreate() {
        this.product = new Product();
    }

    public void Create(Product p) {
        productRepository.Create(p);
        this.list = productRepository.ShowAll();
    }

    public void beforeEdit(Product p) {
        this.product = productRepository.ShowById(p.getId());
    }

    public void Edit() {
        productRepository.Edit(this.product);
        this.list = productRepository.ShowAll();
    }

    public void Delete(Product p) {
        productRepository.Delete(p);
        this.list = productRepository.ShowAll();
    }

}
